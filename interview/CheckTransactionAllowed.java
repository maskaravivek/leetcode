package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckTransactionAllowed {

    static class Rule {
        String key;
        String operator;
        String value;

        public Rule(String key, String value, String operator) {
            this.key = key;
            this.value = value;
            this.operator = operator;
        }
    }

    static class Rules {
        String type;
        Map<String, List<Rule>> ruleMap;

        public Rules() {

        }

        public Rules(String type, Map<String, List<Rule>> ruleMap) {
            this.type = type;
            this.ruleMap = ruleMap;
        }
    }

    public static void main(String[] args) {
        String charge = "[\"CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA\",\"ALLOW:amount>500ANDip_country==CA\",\"BLOCK:card_country==CAORcard_country==MA\",  ]\n";
        String charge1 = "[\"CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA\",\"ALLOW:amount>500ANDip_country==CA\",\"BLOCK:card_country==USANDamount<200\",  ]\n";
        String charge2 = "[\"CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA\",\"ALLOW:currency==EUR\",  ]\n";
        String charge3 = "[\"CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA\",\"BLOCK:amount>500\",  ]\n";

        System.out.println(solution(charge));
        System.out.println(solution(charge1));
        System.out.println(solution(charge2));
        System.out.println(solution(charge3));
    }

    public static boolean solution(String charge) {

        charge = charge.replace("[", "").replace("]", "");
        String[] rules = charge.split(",");

        for (String rule : rules) {
            System.out.println(rule);
        }

        Map<String, String> request = new HashMap<>();
        Rules allowRules = new Rules();
        Rules blockRules = new Rules();

        for (String rule : rules) {
            rule = rule.replaceAll("\"", "");
            if (rule.startsWith("CHARGE")) {
                request = processCharge(rule);
            }

            if (rule.startsWith("ALLOW")) {
                allowRules = processRule("ALLOW", rule);
            }

            if (rule.startsWith("BLOCK")) {
                blockRules = processRule("BLOCK", rule);
            }
        }

        boolean[] allowed = new boolean[2];
        boolean[] blocked = new boolean[2];
        int allowedIdx = 0, blockedIdx = 0;

        for (String key : request.keySet()) {
            String requestValue = request.get(key);
            if (allowRules.ruleMap != null && allowRules.ruleMap.containsKey(key)) {
                List<Rule> rule = allowRules.ruleMap.get(key);
                for (Rule r : rule) {
                    allowed[allowedIdx++] = validateCondition(r, requestValue);
                }
            }
            if (blockRules.ruleMap != null && blockRules.ruleMap.containsKey(key)) {
                List<Rule> rule = blockRules.ruleMap.get(key);
                for (Rule r : rule) {
                    blocked[blockedIdx++] = !validateCondition(r, requestValue);
                }
            }
        }

        boolean allowedRes = false, blockedRes = true;

        if (allowRules.ruleMap == null) {
            allowedRes = false;
        } else {
            if (allowRules.type.equals("")) {
                allowedRes = allowed[0];
            } else if (allowRules.type.equals("AND")) {
                allowedRes = allowed[0] && allowed[1];
            } else if (allowRules.type.equals("OR")) {
                allowedRes = allowed[0] || allowed[1];
            }
        }

        if (blockRules.ruleMap == null) {
            blockedRes = false;
        } else {
            if (blockRules.type.equals("")) {
                blockedRes = blocked[0];
            } else if (blockRules.type.equals("AND")) {
                blockedRes = blocked[0] && blocked[1];
            } else if (blockRules.type.equals("OR")) {
                blockedRes = blocked[0] || blocked[1];
            }
        }

        // System.out.println(allowedRes && !blockedRes);
        return allowedRes && !blockedRes;
    }

    public static boolean validateCondition(Rule rule, String requestValue) {
        String operator = rule.operator;
        String val = rule.value;

        if (operator.equals("==")) {
            return val.equals(requestValue);
        } else if (operator.equals(">")) {
            return Integer.parseInt(requestValue) > Integer.parseInt(val);
        } else if (operator.equals("<")) {
            return Integer.parseInt(requestValue) < Integer.parseInt(val);
        } else if (operator.equals("<=")) {
            return Integer.parseInt(requestValue) <= Integer.parseInt(val);
        } else if (operator.equals(">=")) {
            return Integer.parseInt(requestValue) >= Integer.parseInt(val);
        } else if (operator.equals("!=")) {
            return Integer.parseInt(requestValue) != Integer.parseInt(val);
        }
        return false;
    }

    public static Rules processRule(String identifier, String rule) {
        Map<String, List<Rule>> rules = new HashMap<>();
        rule = rule.replace(identifier + ":", "");
        String type = rule.contains("AND") ? "AND" : rule.contains("OR") ? "OR" : "";

        if (type.equals("")) {
            Rule r = parseRule(rule);
            rules.put(r.key, Arrays.asList(r));
            return new Rules("", rules);
        }

        String[] split = rule.split(type);
        for (String item : split) {
            Rule r = parseRule(item);
            if (!rules.containsKey(r.key)) {
                rules.put(r.key, new ArrayList<>());
            }
            rules.get(r.key).add(r);
        }
        Rules rulesObject = new Rules(type, rules);
        return rulesObject;
    }

    public static Map<String, String> processCharge(String rule) {
        Map<String, String> rules = new HashMap<>();
        rule = rule.replace("CHARGE:", "");
        String[] split = rule.split("&");
        for (String item : split) {
            String[] s = item.split("=");
            rules.put(s[0], s[1]);
        }
        return rules;
    }

    public static Rule parseRule(String rule) {
        String key = "", val = "", operator = "";
        boolean isKey = true;
        char[] arr = rule.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (isOperator(c)) {
                if (operator.equals("")) {
                    isKey = false;
                }
                operator += c;
            } else {
                if (isKey) {
                    key += c;
                } else {
                    val += c;
                }
            }
        }
        return new Rule(key, val, operator);
    }

    public static boolean isOperator(char c) {
        return c == '>' || c == '<' || c == '=' || c == '!';
    }
}
