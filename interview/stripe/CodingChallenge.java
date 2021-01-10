package interview.stripe;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodingChallenge {

    static enum Status {
        CHARGED, CONFIRM, REFUND, PAYOUT
    }

    static class Charge {
        long amount;
        String network;
        Status status;

        public Charge(long amount, String network) {
            this.amount = amount;
            this.network = network;
            this.status = Status.CHARGED;
        }
    }

    static Map<String, Double> cardNetworkFees = new HashMap<>();

    static Map<String, String> chargeMerchantIdMap = new HashMap<>();

    static Map<String, Map<String, Charge>> merchantChargesMap = new HashMap<>();

    public static void process_actions(List<String> input_lines) throws Exception {
        System.out.println(input_lines);
        int idx = 0;
        int cardNets = Integer.parseInt(input_lines.get(idx));

        idx++;
        for (int i = 0; i < cardNets; i++) {
            String[] split = input_lines.get(idx).split(" ");
            double fees = Float.parseFloat(split[1]) / 100.0;
            cardNetworkFees.put(split[0], fees);
            idx++;
        }

        for (int i = idx; i < input_lines.size(); i++) {
            URI uri = new URI(input_lines.get(i));

            String path = uri.getPath();
            List<NameValuePair> params = URLEncodedUtils.parse(uri, "UTF-8");

            Map<String, String> paramMap = getParamMap(params);
            switch (path) {
                case "/charge":
                    addCharge(paramMap);
                    break;
                case "/payout":
                    String mid = paramMap.get("merchant_id");
                    // double payout = payout(mid);
                    // System.out.println(payout);
                    long amount = (long) Math.ceil(payout(mid));
                    System.out.println(mid + ", " + amount);
                    break;
                case "/refund":
                    refund(paramMap.get("charge_id"));
                    break;
                case "/confirm":
                    confirm(paramMap.get("charge_id"));
                    break;
            }

        }

    }

    public static void addCharge(Map<String, String> params) {
        Charge charge = new Charge(Long.parseLong(params.get("amount")), params.get("network"));
        String mid = params.get("merchant_id");
        String cid = params.get("charge_id");
        chargeMerchantIdMap.put(cid, mid);
        if (!merchantChargesMap.containsKey(mid)) {
            merchantChargesMap.put(mid, new HashMap<>());
        }

        merchantChargesMap.get(mid).put(cid, charge);
    }

    public static void refund(String cid) {
        String mid = chargeMerchantIdMap.get(cid);
        Charge charge = merchantChargesMap.get(mid).get(cid);
        charge.status = Status.REFUND;
        merchantChargesMap.get(mid).put(cid, charge);
    }

    public static void confirm(String cid) {
        // System.out.println(cid);
        String mid = chargeMerchantIdMap.get(cid);
        Charge charge = merchantChargesMap.get(mid).get(cid);
        charge.status = Status.CONFIRM;
        merchantChargesMap.get(mid).put(cid, charge);
    }

    public static double payout(String mid) {
        Map<String, Charge> charges = merchantChargesMap.get(mid);
        double payoutAmount = 0;
        for (String key : charges.keySet()) {
            Charge charge = charges.get(key);
            payoutAmount += calculatePayoutAmountForCharge(charge);
            charge.status = Status.PAYOUT;
            charges.put(key, charge);
        }
        merchantChargesMap.put(mid, charges);
        return payoutAmount;
    }

    public static double calculatePayoutAmountForCharge(Charge charge) {
        double amount = 0;
        // System.out.println(charge.amount+" " +cardNetworkFees.get(charge.network)+" "+ charge.status);
        if (charge.status == Status.CONFIRM) {
            double fees = (0.02 * charge.amount) + (cardNetworkFees.get(charge.network) * charge.amount);
            amount = charge.amount - fees;
        } else if (charge.status == Status.REFUND) {
            amount = -(cardNetworkFees.get(charge.network) * charge.amount);
        }

        // System.out.println(amount);
        return amount;
    }

    public static Map<String, String> getParamMap(List<NameValuePair> params) {
        Map<String, String> map = new HashMap<>();
        for (NameValuePair pair : params) {
            map.put(pair.getName(), pair.getValue());
        }
        return map;
    }
}