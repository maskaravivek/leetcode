// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
package leetcode.stack;

import java.util.Stack;

/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 */

// @lc code=start
class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();

        char[] arr = S.toCharArray();

        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(arr[i]);
            } else if (arr[i] == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    cnt++;
                }
            }
        }

        return stack.size() + cnt;
    }
}
// @lc code=end
