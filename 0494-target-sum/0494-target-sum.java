class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int sum=0;
        for(int num: nums)
        sum += num;

        if(target>sum || target<-sum) return 0;

        int dp[][] = new int[n+1][2*sum+1];
        int offset=sum;
        dp[0][0+offset]=1;

        for(int i=1; i<n+1; i++){
            for(int j=-sum; j<=sum; j++){
                int idx=j+offset;
            
                if(idx+nums[i-1]>=0 && idx+nums[i-1] < 2*sum+1){
                    dp[i][idx] += dp[i-1][idx+nums[i-1]];
                }
                if(idx-nums[i-1] >= 0 && idx-nums[i-1]<2*sum+1){
                    dp[i][idx] += dp[i-1][idx-nums[i-1]];
                }
            }
        }
        return dp[n][target+offset];
    }
}