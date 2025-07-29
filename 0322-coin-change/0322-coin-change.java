class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];

        //dp[i][j] = min no. coins in first i-coins that can make j
        dp[0][0] = 0;
        for(int i=1; i<n+1; i++){
            dp[i][0]=0;
        }

        for(int j=1; j<amount+1; j++){
            dp[0][j] = Integer.MAX_VALUE-1;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<amount+1; j++){
                //valid
                if(coins[i-1]<=j){
                    //include 
                    int include = dp[i][j-coins[i-1]]+1;
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.min(include, exclude);
                }
                else
                dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][amount]>=Integer.MAX_VALUE-1? -1: dp[n][amount];

    }
}