class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int dp[][] = new int[n][n+1];

        for(int prevIdx=-1; prevIdx < n-1; prevIdx++){
            if(prevIdx==-1 || nums[prevIdx] < nums[n-1]){
                dp[n-1][prevIdx+1] = 1;
            }
        }

        

        for(int currIdx=n-2; currIdx>=0; currIdx--){
            for(int prevIdx=currIdx-1; prevIdx >= -1; prevIdx--){
                int skip = dp[currIdx+1][prevIdx+1];
                if(prevIdx == -1 || nums[prevIdx] < nums[currIdx]){
                    int take = 1 + dp[currIdx+1][currIdx+1];
                    dp[currIdx][prevIdx+1] = Math.max(take, skip);
                }
                else dp[currIdx][prevIdx+1] = skip;
            }
        }
        
        return dp[0][0];
    }

    
}
