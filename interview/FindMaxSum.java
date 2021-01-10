package interview;

public class FindMaxSum {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(findMaxNum(4, 8, 5));
    }

    public static int findMaxNum(int x, int y, int z) {
        int diff = y - x;

        if (diff == 0) {
            if (z % 2 != 0) {
                return -1;
            } else {
                return x + (z / 2);
            }
        } else if (diff > 0) {
            if (diff > z) {
                return -1;
            } else if (diff == z) {
                return y;
            } else {
                return y + (z - diff) / 2;
            }
        } else {
            if (Math.abs(diff) > z) {
                return -1;
            } else if (Math.abs(diff) == z) {
                return x;
            } else {
                return x + (z - Math.abs(diff)) / 2;
            }
        }
    }

    public static int findMaxNum2(int x, int y, int z) {
        int diff = y - x;

        if (diff >= 0 && z >= diff) {
            int md = z - diff;
            if (md % 2 != 0) {
                return -1;
            } else {
                return y + (md / 2);
            }
        } else if (diff < 0 && z >= Math.abs(diff)) {
            int md = Math.abs(diff) - z;
            if (md % 2 != 0) {
                return -1;
            } else
                return x + md / 2;
        } else {
            return -1;
        }

    }
}