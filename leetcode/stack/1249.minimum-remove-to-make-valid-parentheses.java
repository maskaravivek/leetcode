// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
package leetcode.stack;

import java.util.Stack;

/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char arr[] = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 97 && arr[i] <= 122) {
                continue;
            } else if (arr[i] == '(') {
                stack.push(i);
            } else if (arr[i] == ')') {
                if (!stack.isEmpty()) {
                    int idx = stack.pop();
                } else {
                    arr[i] = ' ';
                }
            }
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = ' ';
        }

        String res = "";

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                res += arr[i];
            }
        }
        return res;
    }
}
// @lc code=end
