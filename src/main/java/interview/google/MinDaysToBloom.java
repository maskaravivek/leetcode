package interview.google;

public class MinDaysToBloom {
    int minDaysBloom(int[] roses, int k, int n) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < roses.length; i++) {
            max = Math.max(max, roses[i]);
            min = Math.min(min, roses[i]);
        }

        int low = min;
        int high = max;

        while (low < high) {
            int mid = (low + high) / 2;

            int bouquets = 0, blooms = 0;
            for (int i = 0; i < roses.length; i++) {
                if (roses[i] <= mid) {
                    blooms++;
                } else {
                    blooms = 0;
                }

                if (blooms == k) {
                    bouquets++;
                    blooms = 0;
                }
            }
            if (bouquets < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
