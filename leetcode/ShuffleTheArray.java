package leetcode;

class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int xi = 0;
        int yi = n;
        
        int res[] = new int[2*n];
        int idx = 0;
        while(xi<n && yi< 2*n) {
            res[idx++] = nums[xi++];
            res[idx++] = nums[yi++];
        }
        
        return res;
    }
}