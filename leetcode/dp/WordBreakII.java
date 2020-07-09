// https://leetcode.com/problems/word-break-ii/

package leetcode.dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakUtil(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    public List<String> wordBreakUtil(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        LinkedList<String> result = new LinkedList<>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = wordBreakUtil(s.substring(word.length()), wordDict, map);
                for (String sub : subList) {
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, result);
        return result;
    }
}