// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

package leetcode.strings;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            int c = arr[i] - 'a';
            if (stack.isEmpty()) {
                stack.add(c);
            } else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        String output = "";
        while (!stack.isEmpty()) {
            int c = stack.pop();
            output += String.valueOf((char) c);
        }
        return new StringBuilder(output).reverse().toString();
    }
}