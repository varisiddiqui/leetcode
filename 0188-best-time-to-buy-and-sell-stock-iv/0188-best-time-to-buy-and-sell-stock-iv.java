class Solution {
    public int maxProfit(int k, int[] prices) {
         int n = prices.length;
        int dp[][][]=new int[n][2][k+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return maxPft(0, 1, k, prices, dp);
    }

     public int maxPft(int i, int buy, int left, int prices[], int dp[][][]){
        if(i==prices.length || left == 0) return 0;

        if(dp[i][buy][left] != -1) return dp[i][buy][left];
        int profit=0;
        
        if(buy==1 && left>0){
            int take = -prices[i]+maxPft(i+1, 0, left, prices, dp);
            int skip = 0 + maxPft(i+1, 1, left, prices, dp);
            profit = Math.max(take, skip);
        }
        else if(buy==0 && left>0){
            int take = prices[i]+maxPft(i+1, 1, left-1, prices, dp);
            int skip = 0+maxPft(i+1, 0, left, prices, dp);
            profit = Math.max(take, skip);
        }

        return dp[i][buy][left]=profit;
    }
}