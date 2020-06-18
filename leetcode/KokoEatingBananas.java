// https://leetcode.com/problems/koko-eating-bananas/

package leetcode;

class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int min = 1, max = 1;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(piles[i], max);
        }

        while (min < max) {
            int mid = (min + max) / 2;
            int hours = hoursForEatingAllBananas(piles, mid);

            if (hours > H) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public int hoursForEatingAllBananas(int[] piles, int k) {
        int hours = 0;

        for (int i = 0; i < piles.length; i++) {
            hours += (piles[i] / k) + (piles[i] % k > 0? 1: 0);
        }
        System.out.println(k+" "+hours);
        return hours;
    }
}
