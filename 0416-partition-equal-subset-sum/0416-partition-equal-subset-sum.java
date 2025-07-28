class Solution {
    public boolean canPartition(int[] nums) {
        //take total elements sum then try to half divide them 
        int n = nums.length;
        int sum=0;
        for(int num: nums)
        sum += num;

        if(sum%2 != 0) return false;

        int target = sum/2;
        int dp[][] = new int[n+1][target+1];

        //here max profit = max sum that can be obtained considering target as j

        for(int i=1; i<n+1; i++){
            for(int j=1; j<target+1; j++){
                //valid
                if(nums[i-1] <= j){
                    int include = dp[i-1][j-nums[i-1]] + nums[i-1];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        if(dp[n][target] == target)
        return true;
        else
        return false;



    }
}