// https://leetcode.com/problems/reverse-vowels-of-a-string/

package leetcode.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        List<Integer> indexes = new ArrayList<>();
        List<Character> vowels = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                indexes.add(i);
                vowels.add(c);
            }
        }

        Collections.reverse(vowels);

        for (int i = 0; i < indexes.size(); i++) {
            arr[indexes.get(i)] = vowels.get(i);
        }

        return String.valueOf(arr);
    }
}
// @lc code=end
