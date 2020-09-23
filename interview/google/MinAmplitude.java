package interview.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinAmplitude {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(solution(new int[] { -1, 3, -1, 8, 5, 4 }));
    }

    public static int solution(int[] arr) {
        if (arr.length <= 4) {
            return 0;
        }
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            maxQueue.add(arr[i]);
            if (maxQueue.size() > 4) {
                maxQueue.poll();
            }
            minQueue.add(arr[i]);
            if (minQueue.size() > 4) {
                minQueue.poll();
            }
        }

        List<Integer> maxList = new ArrayList<>();
        List<Integer> minList = new ArrayList<>();

        while (!maxQueue.isEmpty()) {
            maxList.add(maxQueue.poll());
        }

        while (!minQueue.isEmpty()) {
            minList.add(minQueue.poll());
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            ans = Math.min(ans, maxList.get(i) - minList.get(3 - i));
        }

        return ans;
    }
}
