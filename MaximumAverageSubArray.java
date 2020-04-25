
public class MaximumAverageSubArray {

    public static void main(final String[] args) throws java.lang.Exception {
        int arr[] = new int[] { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        System.out.println(findMaxAverage(arr, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        for (int j = 0; j < k; j++) {
            sum += nums[j];
        }

        double maxAvg = sum / k;

        for (int i = 1; i < nums.length - k + 1; i++) {
            double avg;
            sum = sum - nums[i - 1] + nums[i + k - 1];
            avg = sum / k;

            if (avg > maxAvg) {
                maxAvg = avg;
            }
        }

        return maxAvg;
    }
}