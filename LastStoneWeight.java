import java.util.Arrays;

// https://leetcode.com/problems/last-stone-weight/

class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int idx = stones.length - 1;
        while (idx > 0) {
            int y = stones[idx];
            int x = stones[idx - 1];

            if (x == y) {
                idx = idx - 2;
            } else {
                int rem = Math.abs(y - x);
                stones[idx-1] = rem;
                Arrays.sort(stones);
                idx = idx -1;
            }
        }

        if(idx == -1) {
            return 0;
        } else {
            return stones[0];
        }
    }
}