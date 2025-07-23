class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        int ways = paths(m-1, n-1,dp);
        return ways;
    }

    public int paths(int i, int j, int dp[][]){
        if(i<0 || j<0) return 0;
        if(i==0 && j==0)
        return dp[0][0]=1;
        if(dp[i][j] != 0) return dp[i][j];
        return dp[i][j] = paths(i-1, j, dp)+paths(i, j-1, dp);
    }
}