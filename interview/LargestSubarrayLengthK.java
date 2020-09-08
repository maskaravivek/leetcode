// https://leetcode.com/discuss/interview-question/352459/

package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LargestSubarrayLengthK {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(Arrays.toString(solution(new int[] { 1, 4, 3, 2, 5 }, 4)));

        System.out.println(Arrays.toString(solution(new int[] { 1,1,2 }, 2)));
    }

    public static int[] solution(int[] A, int K) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> {
            for (int i = 0; i < K; i++) {
                if (a.get(i) == b.get(i)) {
                    continue;
                } else {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        List<Integer> subArray = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            subArray.add(A[i]);
        }

        queue.add(new ArrayList<>(subArray));

        for (int i = K; i < A.length; i++) {
            int idx = subArray.remove(0);

            subArray.add(A[i]);
            queue.add(new ArrayList<>(subArray));
            if (queue.size() > 1) {
                queue.poll();
            }
        }

        int[] result = new int[K];
        List<Integer> res = queue.poll();

        for (int i = 0; i < K; i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}
