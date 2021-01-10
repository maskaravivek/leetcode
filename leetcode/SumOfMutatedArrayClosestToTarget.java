// https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/

package leetcode;

class SumOfMutatedArrayClosestToTarget {
    public int findBestValue(int[] arr, int target) {
        int min = 0, max = -1;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        int diff = target;
        int prev = max;
        while (min <= max) {
            int mid = (min + max) / 2;
            int sum = sumForGivenValue(arr, mid, target);

            int currentdiff = Math.abs(sum - target);

            if (currentdiff < diff) {
                diff = currentdiff;
                prev = mid;
            } else if (currentdiff == diff) {
                prev = Math.min(prev, mid);
            }

            if (sum > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return prev;
    }

    public int sumForGivenValue(int[] arr, int value, int target) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] > value ? value : arr[i];
        }
        return sum;
    }
}
