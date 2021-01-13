package interview.amazon;

import java.util.PriorityQueue;

public class MultiprocessorSystem {
    public static void main(String[] args) throws java.lang.Exception {
        System.out.println(multiprocessorSystem(5, new int[] { 4, 2, 8, 3, 5 }, 19));
    }

    public static int multiprocessorSystem(int num, int[] power, int tasks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < power.length; i++) {
            queue.add(power[i]);
        }

        int totalTime = 0;

        while (tasks > 0) {
            int pow = queue.poll();
            tasks -= pow;
            totalTime += 1;
            queue.add(pow / 2);
        }

        return totalTime;
    }
}
