// https://leetcode.com/problems/detect-capital/
package leetcode.strings;

/*
 * @lc app=leetcode id=520 lang=java
 *
 * [520] Detect Capital
 */

// @lc code=start
class DetectCaptials {
    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();

        int capitals = 0, lastIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 65 && arr[i] <= 90) {
                capitals++;
                lastIdx = i;
            }
        }

        return capitals == 0 || capitals == word.length() || (capitals == 1 && lastIdx == 0);
    }
}
// @lc code=end
