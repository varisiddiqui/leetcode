class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);   
        climb(n, dp);  
        return dp[n];   
    }

    public int climb(int n, int dp[]){
        if(n==0)
        return dp[n]=1;
        else if(n<0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n]=climb(n-1, dp)+climb(n-2, dp);

    }
}