package leetcode;

/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 */

// @lc code=start
class NumArray {

    int[] segmentTree;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        int len = 0;

        if (nums.length == 0) {
            return;
        }
        if (isPowerOfTwo(nums.length)) {
            len = 2 * nums.length - 1;
        } else {
            len = 2 * nextPowerOf2(nums.length) - 1;
        }

        segmentTree = new int[len];

        construct(nums, segmentTree, 0, nums.length - 1, 0);
    }

    public void construct(int[] nums, int segmentTree[], int low, int high, int pos) {
        if (low == high) {
            segmentTree[pos] = nums[low];
            return;
        }

        int mid = (low + high) / 2;

        construct(nums, segmentTree, low, mid, 2 * pos + 1);
        construct(nums, segmentTree, mid + 1, high, 2 * pos + 2);
        segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
    }

    public void update(int i, int val) {
        int diff = val - nums[i];

        nums[i] = val;
        updateSegmentTree(segmentTree, 0, nums.length - 1, diff, i, 0);
    }

    public int sumRange(int i, int j) {
        if (nums.length == 0) {
            return 0;
        }
        return rangeSumQuery(segmentTree, i, j, 0, nums.length - 1, 0);
    }

    public void updateSegmentTree(int[] segmentTree, int low, int high, int diff, int index, int pos) {
        if (index < low || index > high) {
            return;
        }

        segmentTree[pos] += diff;

        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        updateSegmentTree(segmentTree, low, mid, diff, index, 2 * pos + 1);
        updateSegmentTree(segmentTree, mid + 1, high, diff, index, 2 * pos + 2);
    }

    public int rangeSumQuery(int[] segmentTree, int qLow, int qHigh, int low, int high, int pos) {
        if (qLow <= low && qHigh >= high) {
            return segmentTree[pos];
        } else if (qLow > high || qHigh < low) {
            return 0;
        }

        int mid = (low + high) / 2;

        return rangeSumQuery(segmentTree, qLow, qHigh, low, mid, 2 * pos + 1)
                + rangeSumQuery(segmentTree, qLow, qHigh, mid + 1, high, 2 * pos + 2);
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

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); obj.update(i,val); int param_2 = obj.sumRange(i,j);
 */
// @lc code=end
