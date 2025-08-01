class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy=1;
        int dp[][] = new int[n][2];
        for(int i=0; i<n; i++)
        Arrays.fill(dp[i], -1);
        return maxPft(0, buy, n, prices, dp);
    }

    public int maxPft(int ind, int buy, int n, int prices[], int dp[][]){
        if(ind == n)
        return 0;

        if(dp[ind][buy] != -1)
        return dp[ind][buy];
        int profit=0;

        if(buy == 1){
            int take = -prices[ind] + maxPft(ind+1, 0, n, prices, dp);
            int skip = 0 + maxPft(ind+1, 1, n, prices, dp);
            profit = Math.max(take, skip);
        }
        else{
            int take = prices[ind] + maxPft(ind+1, 1, n, prices, dp);
            int skip = 0 + maxPft(ind+1, 0, n, prices, dp);
            profit = Math.max(take, skip);
        }

        return dp[ind][buy]=profit;
    }

}