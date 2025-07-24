class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        dp[0][0] = triangle.get(0).get(0);

        for(int i=1; i<n; i++){
            dp[i][0]= dp[i-1][0]+triangle.get(i).get(0);
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<=i; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(min, dp[n-1][i]);
        }
        return min;
    }
}