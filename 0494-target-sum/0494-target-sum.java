class Solution {
    public int findTargetSumWays(int[] nums, int tar) {
        int n = nums.length;
        //calculate max target  
        int sum =0;
        for(int num: nums)
        sum += num;

        if(tar<-sum || tar>sum) return 0;

        int dp[][] = new int[n+1][2*sum+1];
        int offset =sum;
        dp[0][0+offset] = 1;

        for(int i=1; i<n+1; i++){
            for(int j=-sum; j<=sum; j++){
                int target = j+offset;
                if(target-nums[i-1] >= 0 && target-nums[i-1] < (2*sum+1)){
                    dp[i][target] += (dp[i-1][target-nums[i-1]]);
                }
                if(target+nums[i-1]>=0 && target+nums[i-1] <(2*sum+1)){
                    dp[i][target] += (dp[i-1][target+nums[i-1]]);
                }
            }
        }

        return dp[n][tar+offset];
    }
}