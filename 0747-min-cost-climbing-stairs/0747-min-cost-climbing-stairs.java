class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n==1){
            return cost[0];
        }
        else if(n==2){
            return Math.min(cost[0], cost[1]);
        }

        
        int dp[] = new int[n+2];
        dp[0]=0;
        dp[1]=0;
        dp[2]=0;
        for(int i=3; i<=n+1; i++){
            dp[i] = Math.min(cost[i-2]+dp[i-1], cost[i-3]+dp[i-2]);
        }
        return dp[n+1];

        
    }
}