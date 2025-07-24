class Solution {
    public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int dp[][] = new int[n][n];
            for(int j=0; j<n; j++){
                dp[0][j] = matrix[0][j];
            }

            for(int i=1; i<n; i++){
                for(int j=0; j<n; j++){
                    int option1 = (j-1 >= 0)? dp[i-1][j-1]: Integer.MAX_VALUE;
                    int option2 = dp[i-1][j];
                    int option3 = (j+1 <n)? dp[i-1][j+1]: Integer.MAX_VALUE;

                    dp[i][j] = Math.min(Math.min(option1, option2), option3) + matrix[i][j];

                }
            }

            int min = Integer.MAX_VALUE;
            for(int j=0; j<n; j++)
            min = Math.min(min, dp[n-1][j]);
            return min;


    }
}