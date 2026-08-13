class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1; i<n; i++){
            for(int j=0; j<triangle.get(i).size(); j++){
                int min = Integer.MAX_VALUE;
                if(j-1>=0 && j-1<triangle.get(i-1).size())
                 min = Math.min(min, dp[i-1][j-1]);

                if(j>=0 && j<triangle.get(i-1).size())
                min = Math.min(min, dp[i-1][j]);
                dp[i][j] = triangle.get(i).get(j)+min;
            }
        }

        int min=Integer.MAX_VALUE;

        for(int i=0; i<n; i++) min = Math.min(min, dp[n-1][i]);

        return min; 
    }
}