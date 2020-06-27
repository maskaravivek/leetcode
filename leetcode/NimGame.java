// https://leetcode.com/problems/nim-game/

package leetcode;

public class NimGame {
    public boolean canWinNim(int n) {
        if (n < 4) {
            return true;
        }
        if (n == 4) {
            return false;
        }
        boolean win[] = new boolean[n + 1];
        win[0] = true;
        win[1] = true;
        win[2] = true;
        win[3] = true;
        win[4] = false;

        for (int i = 4; i <= n; i++) {
            win[i] = !(win[i - 1] && win[i - 2] && win[i - 3]);
        }
        return win[n];
    }
}