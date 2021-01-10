// https://leetcode.com/problems/summary-ranges
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(final int[] nums) {
        if(nums.length == 0) {
            return new ArrayList<>();
        }
        final List<String> res = new ArrayList<>();

        int firstNum = nums[0];
        int lastNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - lastNum == 1) {
                lastNum = nums[i];
            } else {
                if (firstNum == lastNum) {
                    res.add(String.valueOf(firstNum));
                } else {
                    res.add(firstNum + "->" + lastNum);
                }
                firstNum = nums[i];
                lastNum = nums[i];
            }
        }

        if (firstNum == lastNum) {
            res.add(String.valueOf(firstNum));
        } else {
            res.add(firstNum + "->" + lastNum);
        }
        return res;
    }
}