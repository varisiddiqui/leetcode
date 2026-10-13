class Solution {
    static int sq[] = new int[100];

    static {
        for(int i=1; i<=100; i++){
            sq[i-1]= i*i;
        }
    }

    
    public int numSquares(int n) {
        //find index till which it can be limited
        int k=99;

        while(sq[k] > n) k--;

        int dp[][] = new int[k+2][n+1];

        //dp[i][j] = least number of perfect sq considering till ith index to sum j

        for(int i=0; i<k+2; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        for(int i=0; i<k+2; i++) dp[i][0]=0;

        for(int i=1; i<k+2; i++){
            for(int j=1; j<n+1; j++){
                //invalid
                dp[i][j] = dp[i-1][j];

                //valid
                if(sq[i-1] <= j){
                    dp[i][j] = Math.min(dp[i][j], 1+dp[i][j-sq[i-1]]);
                }
            }
        }

        return dp[k+1][n];
    }
}