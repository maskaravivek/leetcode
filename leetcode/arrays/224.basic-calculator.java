package leetcode.arrays;

import java.util.Stack;

/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public static int calculate(String s) {
        char[] equation = s.toCharArray();

        Stack<String> stack = new Stack<>();

        String num = "";

        for (int i = 0; i < equation.length; i++) {
            char c = equation[i];
            if (c == '(') {
                stack.push(String.valueOf(c));
            } else if (c == '+' || c == '-') {
                if (!num.equals("")) {
                    stack.push(num);
                    num = "";
                }
                stack.push(String.valueOf(c));
            } else if (c == ' ') {
                if (!num.equals("")) {
                    stack.push(num);
                    num = "";
                }
            } else if (c >= 48 && c <= 57) {
                num += c;
            } else if (c == ')') {
                if (!num.equals("")) {
                    stack.push(num);
                    num = "";
                }
                int res = 0, minus = 0;
                String last = "";

                while (!stack.peek().equals("(")) {
                    String str = stack.pop();
                    if (str.equals("+") || str.equals("-")) {
                        if (str.equals("+")) {
                            res += Integer.parseInt(last);
                        } else {
                            minus += Integer.parseInt(last);
                        }
                        last = "";
                    } else {
                        last = str;
                    }
                }

                if (!last.equals("")) {
                    res += Integer.parseInt(last);
                }

                res = res - minus;

                stack.pop();
                stack.push(String.valueOf(res));
            }
        }

        if (!num.equals("")) {
            stack.push(num);
            num = "";
        }

        int res = 0, minus = 0;
        String last = "";

        while (!stack.isEmpty()) {
            String str = stack.pop();
            if (str.equals("+") || str.equals("-")) {
                if (str.equals("+")) {
                    res += Integer.parseInt(last);
                } else {
                    minus += Integer.parseInt(last);
                }
                last = "";
            } else {
                last = str;
            }
        }

        if (!last.equals("")) {
            res += Integer.parseInt(last);
        }

        res = res - minus;

        return res;
    }
}
// @lc code=end
