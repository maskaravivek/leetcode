// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets
package leetcode;

public class MinNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }

        int min = 0, max = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        while (min < max) {
            int mid = (min + max) / 2;
            int bouquets = getBouquets(bloomDay, mid, k);
            if (bouquets < m) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public int getBouquets(int[] bloomDay, int day, int k) {
        int flowers = 0, bouquets = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                flowers++;
            } else {
                flowers = 0;
            }
            if (flowers == k) {
                bouquets++;
                flowers = 0;
            }
        }
        return bouquets;
    }
}