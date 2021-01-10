// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

package leetcode;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }

        while (left < right) {
            int mid = (left + right) / 2;

            int current = 0, days = 1;
            for (int i = 0; i < weights.length; i++) {
                if (current + weights[i] <= mid) {
                    current += weights[i];
                } else {
                    current = weights[i];
                    days += 1;
                }
            }

            if (days > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}