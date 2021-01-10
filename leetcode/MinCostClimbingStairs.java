package leetcode;

// https://leetcode.com/problems/min-cost-climbing-stairs

class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[]= new int[n];
        
        for(int i=0; i< n; i++) {
            if(i<=1) {
                dp[i] = cost[i];
            } else {
                dp[i] = Integer.MAX_VALUE;
            }
        }
        
        for(int i=2; i< n; i++) {
            for(int j=i-2; j< i; j++) {
                dp[i] = min(dp[i], dp[j] + cost[i]);   
            }
        }
        return min(dp[n-1], dp[n-2]);
    }
    
    public int min(int a, int b) {
        return a>b?b:a;
    }
}