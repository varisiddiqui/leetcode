class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int dp[][] = new int[n+2][2];
        //starts from the ith day

        dp[n][0]=dp[n][1]=0;//base cases no days left
        for(int i=n-1; i>=0; i--){
            int profit=0;
            for(int j=0; j<=1; j++){
                if(j==1){//buy
                    profit = Math.max(-prices[i]+dp[i+1][0], dp[i+1][1]); //bought, skipped
                }
                else{
                    profit = Math.max(prices[i]+dp[i+2][1], dp[i+1][0]); //sold,skipped
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][1];
    }
}

