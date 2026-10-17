class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n];
        Arrays.fill(dp, -1);

       return canReach(0, nums, dp) == 1;
    }

    public int canReach(int curr_idx, int nums[], int dp[]){
        if(curr_idx >= nums.length-1) return 1;

        if(dp[curr_idx] != -1) return dp[curr_idx];



        for(int i=1; i<=nums[curr_idx]; i++){
            if(canReach(curr_idx+i, nums, dp)==1){
                return dp[curr_idx]=1;
            }
        }

        return dp[curr_idx] = 0;
    }

    
}