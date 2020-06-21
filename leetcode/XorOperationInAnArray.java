package leetcode;

class XorOperationInAnArray {
    public int xorOperation(int n, int start) {
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }

        int xor = 0;

        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }
}