// https://leetcode.com/problems/solve-the-equation/

package leetcode.strings;
/*
 * @lc app=leetcode id=640 lang=java
 *
 * [640] Solve the Equation
 */

// @lc code=start
class SolveTheEquation {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(solveEquation("x+5-3+x=6+x-2"));
        System.out.println(solveEquation("x=x"));
        System.out.println(solveEquation("2x=x"));
        System.out.println(solveEquation("2x+3x-6x=x+2"));
        System.out.println(solveEquation("x=x+2"));
        System.out.println(solveEquation("x-10=10-x+x+2x"));
    }

    public static String solveEquation(String equation) {
        int leftX = 0, rightX = 0, leftNum = 0, rightNum = 0;

        char sign = ' ';
        boolean left = true;

        String num = "";

        char[] arr = equation.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '=') {
                if (!num.equals("")) {
                    int coeff = Integer.parseInt(num);
                    leftNum = sign == ' ' ? coeff : (sign == '+' ? leftNum + coeff : leftNum - coeff);
                    num = "";
                }
                sign = ' ';
                left = false;
            }
            if (arr[i] == '+' || arr[i] == '-') {
                if (!num.equals("")) {
                    int coeff = Integer.parseInt(num);
                    if (left) {
                        leftNum = sign == ' ' ? coeff : (sign == '+' ? leftNum + coeff : leftNum - coeff);
                    } else {
                        rightNum = sign == ' ' ? coeff : (sign == '+' ? rightNum + coeff : rightNum - coeff);
                    }
                    num = "";
                }
                sign = arr[i];
            } else if (arr[i] >= 48 && arr[i] <= 57) {
                num += arr[i];
            } else if (arr[i] == 'x') {
                int coeff = 1;
                if (!num.equals("")) {
                    coeff = Integer.parseInt(num);
                    num = "";
                }

                if (left) {
                    leftX = sign == ' ' ? coeff : (sign == '+' ? leftX + coeff : leftX - coeff);
                } else {
                    rightX = sign == ' ' ? coeff : (sign == '+' ? rightX + coeff : rightX - coeff);
                }
                sign = ' ';
            }
        }

        if (!num.equals("")) {
            int coeff = Integer.parseInt(num);
            if (left) {
                leftNum = sign == ' ' ? coeff : (sign == '+' ? leftNum + coeff : leftNum - coeff);
            } else {
                rightNum = sign == ' ' ? coeff : (sign == '+' ? rightNum + coeff : rightNum - coeff);
            }
            num = "";
        }

        if (leftX == rightX) {
            if (leftNum == rightNum) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {

            int lhs = leftX - rightX;
            int rhs = rightNum - leftNum;

            int x = rhs / lhs;
            return "x=" + x;
        }
    }
}
// @lc code=end
