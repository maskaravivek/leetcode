/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 */

// @lc code=start
class Solution {
    public String convertToTitle(int n) {

        String title = "";
        while (n > 0) {
            n--;
            char c = (char) (((n % 26) + 'A'));
            title += c;
            n /= 26;
        }

        String result = "";

        for (int i = title.length() - 1; i >= 0; i--) {
            result += title.charAt(i);
        }

        return result;
    }
}
// @lc code=end
