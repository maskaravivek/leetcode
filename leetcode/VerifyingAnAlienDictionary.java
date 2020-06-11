// https://leetcode.com/problems/verifying-an-alien-dictionary

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(String.valueOf(order.charAt(i)), i);
        }

        for (int i = 1; i < words.length; i++) {
            if (!isSorted(words[i-1], words[i], map)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSorted(String word1, String word2, Map<String, Integer> map) {
        int idx1 = 0, idx2 = 0;

        while (idx1 < word1.length() && idx2 < word2.length()) {
            int word1Idx = map.get(String.valueOf(word1.charAt(idx1)));
            int word2Idx = map.get(String.valueOf(word2.charAt(idx2)));
            if (word1Idx< word2Idx) {
                return true;
            } else if(word1Idx == word2Idx) {
                idx1++;
                idx2++;
                continue;
            } else {
                return false;
            }
        }
        return word1.length() < word2.length();
    }
}