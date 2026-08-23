class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        //dp[idx][buy] = maxprofit if buy or sell??
        dp[n-1][0] = prices[n-1];

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=1; j++){
                if(j==1){
                    int buyed = -prices[i] + dp[i+1][0];
                    int notbuyed = 0 + dp[i+1][1];
                    dp[i][j] = Math.max(buyed, notbuyed);
                }
                else{
                    int sold = prices[i] + dp[i+1][1];
                    int notsold = 0 + dp[i+1][0];
                    dp[i][j] = Math.max(sold, notsold);
                }
            }
        }
        
        return dp[0][1];
    }

    
}