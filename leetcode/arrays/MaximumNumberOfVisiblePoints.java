package leetcode.arrays;

import java.util.Arrays;
import java.util.List;

public class MaximumNumberOfVisiblePoints {

    public static void main(String[] args) {
        // System.out.println(calculateAngle(1, 1, 2, 2));
    }

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        double[] angles = new double[points.size()];

        int idx = 0;
        for (List<Integer> point : points) {
            angles[idx++] = calculateAngle(location, point);
        }

        Arrays.sort(angles);

        return computeLongestSubarray(angles, angle);
    }

    public static int computeLongestSubarray(double arr[], int k) {
        int maxLength = 1;

        for (int i = 0; i < arr.length; i++) {
            double minOfSub = arr[i];
            double maxOfSub = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > maxOfSub)
                    maxOfSub = arr[j];

                if (arr[j] < minOfSub)
                    minOfSub = arr[j];

                if ((maxOfSub - minOfSub) <= k) {
                    int currLength = j - i + 1;
                    if (maxLength < currLength)
                        maxLength = currLength;
                }
            }
        }
        return maxLength;
    }

    public static double calculateAngle(List<Integer> point1, List<Integer> point2) {
        double angle = Math.toDegrees(Math.atan2(point2.get(0) - point1.get(0), point2.get(1) - point1.get(1)));
        // Keep angle between 0 and 360
        angle = angle + Math.ceil(-angle / 360) * 360;

        return angle;
    }
}
