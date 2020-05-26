// https://leetcode.com/problems/house-robber-ii

class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } else if(nums.length == 1) {
            return nums[0];
        }
        int dp[] = new int[nums.length+1];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        boolean tookFirst = false;
        for(int i= 2; i< nums.length; i++) {
            if(dp[i-2]+nums[i] > dp[i-1]) {
                dp[i] = dp[i-2]+nums[i];   
                tookFirst = true;
            } else {
                dp[i] = dp[i-1];
            }
        }
        
        int max = tookFirst? dp[nums.length-2]: dp[nums.length-1]; 
        
        int dp2[] = new int[nums.length+1];
        
        dp2[nums.length-1] = nums[nums.length-1];
        dp2[nums.length-2] = Math.max(nums[nums.length-1], nums[nums.length-2]);
        tookFirst = false;
        for(int i= nums.length-3; i>= 0; i--) {
            if(dp2[i+2]+nums[i] > dp2[i+1]) {
                dp2[i] = dp2[i+2]+nums[i];   
                tookFirst = true;
            } else {
                dp2[i] = dp2[i+1];
            }
        }
        int max2 = tookFirst? dp2[1]: dp2[0]; 
        return Math.max(max, max2);
    }
}