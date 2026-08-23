class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        //dp[idx][buy] = maxprofit if buy or sell??
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return maxPr(0, 1, prices, dp);
    }

    public int maxPr(int idx, int buy, int prices[], int dp[][]){

        if(idx == prices.length) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy]; 

        int  profit=0;
        if(buy == 1){
            int buyed = -prices[idx] + maxPr(idx+1, 0, prices, dp);
            int notbuyed = 0 + maxPr(idx+1, 1, prices, dp);

            profit = Math.max(profit, Math.max(buyed, notbuyed));
        }

        if(buy == 0){
            int sold = prices[idx] + maxPr(idx+1, 1, prices, dp);
            int notsold = 0 + maxPr(idx+1, 0, prices, dp);

            profit = Math.max(profit, Math.max(sold, notsold));
        }

        return dp[idx][buy] = profit;
    }
}