// https://leetcode.com/problems/first-unique-character-in-a-string
package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int nonRepeatingChar = -1;
        for (Integer c : map.keySet()) {
            if (map.get(c) == 1) {
                nonRepeatingChar = c;
                break;
            }
        }

        return nonRepeatingChar == -1 ? -1 : s.indexOf('a'+nonRepeatingChar);
    }
}