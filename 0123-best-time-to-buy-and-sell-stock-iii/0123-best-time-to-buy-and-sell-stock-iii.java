class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
       
        //dp[idx][buy] = maxprofit if buy or sell??
        int dp[][][] = new int[n+1][2][3];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<3; k++) dp[i][j][k] = -1;
            }
        }
        

        return maxPr(0, 1, prices, 0, dp);
    }

    public int maxPr(int idx, int buy, int prices[], int cnt, int dp[][][]){

        if(idx == prices.length) return 0;
        if(cnt == 2) return 0;

        if(dp[idx][buy][cnt] != -1) return dp[idx][buy][cnt];

        int  profit=0;
        if(buy == 1){
            int buyed = -prices[idx] + maxPr(idx+1, 0, prices, cnt, dp);
            int notbuyed = 0 + maxPr(idx+1, 1, prices, cnt, dp);

            profit = Math.max(profit, Math.max(buyed, notbuyed));
        }

        if(buy == 0){
            int sold = prices[idx] + maxPr(idx+1, 1, prices, cnt+1, dp);
            int notsold = 0 + maxPr(idx+1, 0, prices, cnt, dp);

            profit = Math.max(sold, notsold);
        }

        return dp[idx][buy][cnt] = profit;
    }
}