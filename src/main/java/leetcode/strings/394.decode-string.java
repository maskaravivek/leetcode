// https://leetcode.com/problems/decode-string/

package leetcode.strings;

import java.util.Stack;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class DecodeString {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("abc3[cd]xyz"));
    }

    public static String decodeString(String s) {
        char[] arr = s.toCharArray();

        Stack<String> stack = new Stack<>();

        String num = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 48 && arr[i] <= 57) {
                num += arr[i];
            } else if (arr[i] == '[') {
                stack.push(num);
                stack.push("[");
                num = "";
            } else if (arr[i] == ']') {
                String repeat = "";
                while (!stack.peek().equals("[")) {
                    repeat += stack.pop();
                }

                stack.pop();

                int times = Integer.parseInt(stack.pop());

                String res = "";
                for (int j = 0; j < times; j++) {
                    res += repeat;
                }

                stack.push(res);
            } else {
                stack.push(String.valueOf(arr[i]));
            }
        }

        String result = "";
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        char[] resultArr = result.toCharArray();

        String finalResult = "";

        for (int i = resultArr.length - 1; i >= 0; i--) {
            finalResult += resultArr[i];
        }

        return finalResult;
    }
}
// @lc code=end
