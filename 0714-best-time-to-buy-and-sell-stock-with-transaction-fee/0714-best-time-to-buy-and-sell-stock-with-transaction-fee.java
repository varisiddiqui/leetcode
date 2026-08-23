class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n  = prices.length;

        int dp[][] = new int[n+1][2];

        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                if(buy == 1){
                    int take = -prices[i]+dp[i+1][0];
                    int skip = 0+dp[i+1][1];
                    dp[i][buy] = Math.max(take, skip);
                }
                else{
                    int sell = prices[i] + dp[i+1][1] - fee;
                    int skip = 0 + dp[i+1][0];
                    dp[i][buy] = Math.max(sell, skip);
                }
            }

        }
        return dp[0][1];
    }
}