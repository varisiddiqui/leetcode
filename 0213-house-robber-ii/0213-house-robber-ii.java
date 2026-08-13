class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];

        int cost=0;
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        cost = Math.max(cost, dp[n-1]);
        Arrays.fill(dp, 0);

        dp[1]=0;
        dp[2]=nums[1];

        for(int i=3; i<n+1; i++){
            dp[i] = Math.max(dp[i-1], nums[i-1]+dp[i-2]);
        }
        cost = Math.max(cost, dp[n]);
        return cost;
    }
}