// https://leetcode.com/discuss/interview-question/394347/

package interview;

public class WateringPlants {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(wateringPlants(new int[] { 2, 4, 5, 1, 2 }, 5, 7));
    }

    public static int wateringPlants(int[] plants, int capacity1, int capacity2) {
        int left = 0;
        int right = plants.length - 1;

        int refill1 = 0, refill2 = 0;

        int current1 = 0, current2 = 0;

        while (left < right) {
            if (current1 < plants[left]) {
                current1 = capacity1;
                refill1++;
            }

            current1 -= plants[left];
            left++;

            if (current2 < plants[right]) {
                current2 = capacity2;
                refill2++;
            }

            current2 -= plants[right];
            right--;
        }

        if (left == right) {
            if (current1 + current2 < plants[left]) {
                refill1++;
            }
        }

        return refill1 + refill2;
    }
}
