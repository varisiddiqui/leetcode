class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++)
        Arrays.fill(dp[i], -1);
        return minSum(m-1, n-1, grid, dp);
    }

    public int minSum(int i, int j, int grid[][], int dp[][]){
        if(i==0 && j==0)
        return dp[i][j]=grid[i][j];
        else if(i<0 || j<0){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1)
        return dp[i][j];
        
        return dp[i][j] = Math.min(minSum(i-1, j, grid, dp), minSum(i, j-1, grid, dp))+grid[i][j];
    }
}