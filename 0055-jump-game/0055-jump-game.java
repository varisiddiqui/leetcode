class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        boolean dp[] = new boolean[n];

        hasReached(0, nums, dp);

        return dp[n-1];
    }

    public boolean hasReached(int curr_idx, int nums[], boolean dp[]){
        if(curr_idx >= nums.length) return true;

        if(dp[curr_idx] == true) return true;

        for(int i=curr_idx+1; i<=Math.min(curr_idx+nums[curr_idx], nums.length-1); i++){
            hasReached(i, nums, dp);
        }

        dp[curr_idx]= true;
        return true;
    }

    
}