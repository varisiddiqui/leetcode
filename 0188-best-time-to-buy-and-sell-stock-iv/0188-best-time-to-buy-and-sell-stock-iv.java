class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][]=new int[n+1][2][k+1];     

        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                for(int left=1; left<=k; left++){
                    int profit=0;
                    if(buy==1 && left>0){
                        int take = -prices[i]+dp[i+1][0][left];
                        int skip = 0+dp[i+1][1][left];
                        profit = Math.max(take, skip);
                    }
                    else if(buy==0 && left>0){
                        int take = prices[i]+dp[i+1][1][left-1];
                        int skip = 0+dp[i+1][0][left];
                        profit = Math.max(take, skip);
                    }
                    dp[i][buy][left] = profit;
                }
            }
        }
        return dp[0][1][k];
    }
}