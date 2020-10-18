// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/

package leetcode.strings;

import java.util.HashSet;
import java.util.Set;

public class SplitStringIntoMaxNumberOfUniqueSubstrings {
    public int maxUniqueSplit(String s) {
        return dfs(new HashSet<>(), 0, s);
    }

    public int dfs(Set<String> results, int idx, String s) {
        if (idx >= s.length()) {
            return 0;
        }
        int res = -1; // no ways

        for (int i = idx + 1; i <= s.length(); i++) {
            String subStr = s.substring(idx, i);
            if (results.contains(subStr)) {
                continue;
            }

            results.add(subStr);

            int next = dfs(results, i, s);
            if (next >= 0) {
                res = Math.max(res, next + 1);
            }
            results.remove(subStr);
        }

        return res;
    }
}
