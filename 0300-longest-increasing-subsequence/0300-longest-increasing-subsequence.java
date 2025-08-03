class Solution {
    static int offset = 1;//coordinate changes for prev
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];

        for(int i=0; i<n; i++)
        Arrays.fill(dp[i], -1);
        return maxL(0, -1, nums, dp);
        
    }

    public int maxL(int curr_idx, int prev_idx, int nums[], int dp[][]){
        if(curr_idx == nums.length)
        return 0;

        if(dp[curr_idx][prev_idx+offset] != -1) return dp[curr_idx][prev_idx+offset];

        int take=0;
        int skip=0;

        //take
        if(prev_idx == -1 || nums[curr_idx] > nums[prev_idx]){
            take = 1 + maxL(curr_idx+1, curr_idx, nums, dp);
        }

        skip = 0 + maxL(curr_idx+1, prev_idx, nums, dp);

        return dp[curr_idx][prev_idx+offset]=Math.max(take, skip);
    }
}