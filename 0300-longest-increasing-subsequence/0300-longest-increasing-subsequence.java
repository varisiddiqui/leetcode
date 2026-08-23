class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int dp[][] = new int[n][n+1];

        for(int i=0; i<n; i++)
        Arrays.fill(dp[i], -1);
        
        return longest(0, -1, nums, dp);
    }

    public int longest(int currIdx, int prevIdx, int nums[], int dp[][]){
        if(currIdx == nums.length) return 0;

        if(dp[currIdx][prevIdx+1] != -1) return dp[currIdx][prevIdx+1];

        int skip = longest(currIdx+1, prevIdx, nums, dp);

        if(prevIdx == -1 || nums[prevIdx] < nums[currIdx]){
            int take = 1 + longest(currIdx+1, currIdx, nums, dp);
            return dp[currIdx][prevIdx+1] = Math.max(take, skip);
        }

        return dp[currIdx][prevIdx+1] = skip;

    }
}
