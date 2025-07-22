class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        if(n == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        //case-1
        int dp[] = new int[n];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);

        for(int i=3; i<n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        int ans1=dp[n-1];

        //case-2
        dp = new int[n];
        dp[0]=0;
        dp[1]=nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for(int i=3; i<n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return Math.max(ans1, dp[n-1]);
    }
}