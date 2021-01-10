// https://leetcode.com/problems/excel-sheet-column-number

package leetcode.arrays;

/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null) {
            return -1;
        }
        char[] arr = s.toCharArray();

        int num = 0;
        for (int i = 0; i <arr.length; i++) {
            num *= 26;
            int n = (arr[i] - 'A') + 1;
            num += n;
        }
        return num;
    }
}
// @lc code=end
