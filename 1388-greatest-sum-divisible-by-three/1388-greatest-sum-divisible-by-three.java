class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int dp[] = new int[3];
        
        for(int i=1; i<n+1; i++){
             int curr[] = dp.clone();

            for(int j=0; j<3; j++){
                int idx = (dp[j] + nums[i-1])%3;
                curr[idx] = Math.max(dp[idx], (Math.max(curr[idx], (dp[j]+nums[i-1]))));
            }

          


           dp=curr;
        }
        return dp[0];
    }
}