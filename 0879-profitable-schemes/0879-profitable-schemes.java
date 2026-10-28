class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int l = group.length;
        int dp[][][] = new int[n+1][l][100+1];

        for(int a[][]: dp){
            for(int b[]: a) Arrays.fill(b, -1);
        }
        return ways(n, 0, 0, minProfit, group, profit, dp);
    }

    public int ways(int n, int curr_idx, int curr_pr, int min_profit, int group[], int profit[], int dp[][][]){
        if(n == 0){
            if(curr_pr == min_profit) return 1;
            else return 0;
        }

        if(curr_idx == group.length){
             if(curr_pr >= min_profit) return 1;
            else return 0;  
        }

        if(dp[n][curr_idx][curr_pr] != -1) return dp[n][curr_idx][curr_pr];

        int ways=0;
        int MOD = 1_000_000_007;

        //pick
        //check validity
        if(n >= group[curr_idx]){
            ways += ways(n-group[curr_idx], curr_idx+1, Math.min(curr_pr+profit[curr_idx], min_profit), min_profit, group, profit, dp);
            ways %= MOD;
        }
    
            ways += ways(n, curr_idx+1, curr_pr, min_profit, group, profit, dp);
            ways %= MOD;
        

        return dp[n][curr_idx][curr_pr]= ways;


        

    }
}