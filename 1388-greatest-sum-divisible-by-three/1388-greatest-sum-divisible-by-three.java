class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][3];
        for(int i=1; i<n+1; i++){
            for(int j=0; j<3; j++){
                int idx = (dp[i-1][j] + nums[i-1])%3;
                dp[i][idx] = Math.max(dp[i-1][idx], (Math.max(dp[i][idx], (dp[i-1][j]+nums[i-1]))));
            }
            for(int j=0; j<3; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
            }
        }
        return dp[n][0];
    }
}