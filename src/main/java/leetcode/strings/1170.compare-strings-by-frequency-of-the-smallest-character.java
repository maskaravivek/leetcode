// https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/

package leetcode.strings;

import java.util.Arrays;

/*
 * @lc app=leetcode id=1170 lang=java
 *
 * [1170] Compare Strings by Frequency of the Smallest Character
 */

// @lc code=start
class CompareStringsByFrequencyOfTheSmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] arrA = new int[words.length];
        int[] arrB = new int[queries.length];

        for (int i = 0; i < words.length; i++) {
            int[] freq = new int[26];

            for (int j = 0; j < words[i].length(); j++) {
                freq[words[i].charAt(j) - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                if (freq[j] > 0) {
                    arrA[i] = freq[j];
                    break;
                }
            }
        }

        Arrays.sort(arrA);

        for (int i = 0; i < queries.length; i++) {
            int[] freq = new int[26];

            for (int j = 0; j < queries[i].length(); j++) {
                freq[queries[i].charAt(j) - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                if (freq[j] > 0) {
                    arrB[i] = freq[j];
                    break;
                }
            }
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            for (int j = arrA.length - 1; j >= 0; j--) {
                if (arrB[i] < arrA[j]) {
                    result[i]++;
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
// @lc code=end
