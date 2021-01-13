package interview.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class EarliestTimeToCompleteDeliveries {

    public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(earlistTimeToCompleteDeliveries(2, new int[]{8, 10}, new int[]{2,2,3,1,8,7,4,5}));
	}
	
	static class IntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }

    public static int earlistTimeToCompleteDeliveries(int numOfBuildings, int[] buildingOpeningTime, int[] offloadTime) {
        Arrays.sort(buildingOpeningTime);

        Integer[] offloadTimeArr = new Integer[offloadTime.length];

        for (int i = 0; i < offloadTime.length; i++) {
            offloadTimeArr[i] = offloadTime[i];
        }

        Arrays.sort(offloadTimeArr, new IntegerComparator());

        int offloadIndex = 0, count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < buildingOpeningTime.length; i++) {
            while (offloadIndex < offloadTimeArr.length && count != 4) {
                max = Math.max(max, buildingOpeningTime[i] + offloadTimeArr[offloadIndex]);
                count++;
                offloadIndex++;
            }

            count = 0;
        }

        return max;
    }
}
