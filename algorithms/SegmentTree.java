package algorithms;

import java.util.Arrays;

public class SegmentTree {

    public static void main(final String[] args) throws java.lang.Exception {
        int[] arr = new int[] { -1, 2, 4, 0 };
        int len = 0;

        if (isPowerOfTwo(arr.length)) {
            len = 2 * arr.length - 1;
        } else {
            len = 2 * nextPowerOf2(arr.length) - 1;
        }

        int[] segmentTree = new int[len];
        constructTree(arr, segmentTree, 0, arr.length - 1, 0);

        System.out.println(Arrays.toString(segmentTree));

        System.out.println(rangeMinQuery(segmentTree, 1, 2, 0, arr.length - 1, 0));
    }

    public static void constructTree(int[] arr, int[] segmentTree, int low, int high, int pos) {
        if (low == high) {
            segmentTree[pos] = arr[low];
            return;
        }

        int mid = (low + high) / 2;

        constructTree(arr, segmentTree, low, mid, 2 * pos + 1);
        constructTree(arr, segmentTree, mid + 1, high, 2 * pos + 2);

        segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
    }

    public static int rangeMinQuery(int[] segmentTree, int qlow, int qhigh, int low, int high, int pos) {
        if (qlow <= low && qhigh >= high) {
            return segmentTree[pos];
        }
        if (qlow > high || qhigh < low) {
            return Integer.MAX_VALUE;
        }
        int mid = (low + high) / 2;

        return Math.min(rangeMinQuery(segmentTree, qlow, qhigh, low, mid, 2 * pos + 1),
                rangeMinQuery(segmentTree, qlow, qhigh, mid + 1, high, 2 * pos + 2));
    }

    // for sum operation
    public void updateVal(int segmentTree[], int low, int high, int diff, int index, int pos) {
        if (index < low || index > high) {
            return;
        }
        segmentTree[pos] += diff;
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        updateVal(segmentTree, low, mid, diff, index, 2 * pos + 1);
        updateVal(segmentTree, mid + 1, high, diff, index, 2 * pos + 2);
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        int rem = 1;
        while (n > 1) {
            rem = n % 2;
            if (rem != 0) {
                return false;
            }
            n = n / 2;
        }
        return rem == 0;
    }

    public static int nextPowerOf2(int n) {
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n++;

        return n;
    }
}
