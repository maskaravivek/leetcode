package leetcode;

class BulbSwitcherIV {
    public int minFlips(String target) {
        char[] t = target.toCharArray();

        char[] arr = new char[target.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = '0';
        }

        int flips = 0;
        for (int i = 0; i < t.length; i++) {
            if ((arr[i] == t[i] && flips % 2 == 0) || (flips % 2 == 1 && arr[i] != t[i])) {
                continue;
            } else {
                flips++;
            }
        }
        return flips;
    }
}