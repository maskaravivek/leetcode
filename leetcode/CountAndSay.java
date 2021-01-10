package leetcode;

class CountAndSay {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String num = "1";
        for (int i = 2; i <= n; i++) {
            char c = num.charAt(0);
            int count = 1;
            String subStr = "";
            for (int j = 1; j < num.length(); j++) {
                if (c == num.charAt(j)) {
                    count++;
                } else {
                    subStr += count + "" + c;
                    count = 1;
                    c = num.charAt(j);
                }
            }
            subStr += count + "" + c;
            num = subStr;
        }
        return num;
    }
}