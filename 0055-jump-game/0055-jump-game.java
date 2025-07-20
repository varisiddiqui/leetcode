class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean dp[] = new boolean[n];
        //dp[i] = can i reach at end from this index
        dp[n-1] = true;
        
        for(int i=n-2; i>=0; i--){
            int steps = nums[i];
            boolean canReach = false;
            for(int j=i+1; j<n && j<=i+steps; j++){
                if(dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}