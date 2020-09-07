// https://leetcode.com/problems/license-key-formatting/

package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=482 lang=java
 *
 * [482] License Key Formatting
 */

// @lc code=start
class LicenseKeyInformation {
    public String licenseKeyFormatting(String S, int K) {
        char[] arr = S.toCharArray();

        List<Character> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '-') {
                list.add(arr[i]);
            }
        }

        String result = "";
        int idx = list.size() - 1;
        while (idx >= 0) {
            for (int i = 0; i < K && idx >= 0; i++) {
                result += Character.toUpperCase(list.get(idx));
                idx--;
            }
            if (idx >= 0) {
                result += "-";
            }
        }

        String actualResult = "";

        for (int i = result.length() - 1; i >= 0; i--) {
            actualResult += result.charAt(i);
        }

        return actualResult;
    }
}
// @lc code=end
