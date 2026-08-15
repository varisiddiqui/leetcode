class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int ans = 0;
        int dp[][] = new int[m][n];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                ans = Math.max(ans, longest(matrix, i, j, dp));
            }
        }
        return ans;
    }

    public int longest(int matrix[][], int row, int col, int dp[][]){
        int m = matrix.length;
        int n = matrix[0].length;

        if(dp[row][col] != 0) return dp[row][col];
        
        int len=0;

        if(row+1 < m && matrix[row][col] < matrix[row+1][col])
        len = Math.max(len, longest(matrix, row+1, col, dp));

        if(row-1 >=0 && matrix[row][col]<matrix[row-1][col])
        len = Math.max(len, longest(matrix, row-1, col, dp));

        if(col+1 < n && matrix[row][col] < matrix[row][col+1])
        len = Math.max(len, longest(matrix, row, col+1, dp));

        if(col-1 >=0 && matrix[row][col] < matrix[row][col-1])
        len = Math.max(len, longest(matrix, row, col-1, dp));

        return dp[row][col] = len+1;
    }
}