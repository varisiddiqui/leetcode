class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][3];
        //dp[idx][buy] = maxprofit if buy or sell??
  

        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                for(int left=2; left>0; left--){
                    if(j==1){
                    int buyed = -prices[i] + dp[i+1][0][left];
                    int notbuyed = 0 + dp[i+1][1][left];
                    dp[i][j][left] = Math.max(buyed, notbuyed);
                }
                else{
                    int sold = prices[i] + dp[i+1][1][left-1];
                    int notsold = 0 + dp[i+1][0][left];
                    dp[i][j][left] = Math.max(sold, notsold);
                }
                }
            }
        }
        
        return dp[0][1][2];
    }

    
}