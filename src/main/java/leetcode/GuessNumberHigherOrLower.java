// https://leetcode.com/problems/guess-number-higher-or-lower

package leetcode;

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = (left/2 + right/2);

            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    int guess(int num) {
        // return -1 if num is lower than the guess number
        // 1 if num is higher than the guess number
        // otherwise return 0
        return 0;
    }
}