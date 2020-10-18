// https://leetcode.com/problems/trapping-rain-water

package leetcode;

public class TrappingRainWater {
    public int trap(int[] height) {
        int left[] = new int[height.length];
        int right[] = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            left[i] = Math.max(height[i], i == 0 ? 0 : left[i - 1]);
        }

        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = Math.max(height[i], i == height.length - 1 ? 0 : left[i + 1]);
        }

        int trapped = 0;
        for (int i = 0; i < height.length; i++) {
            trapped += Math.min(left[i], right[i]) - height[i];
        }
        return trapped;
    }
}