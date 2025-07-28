class Solution {
    public boolean canPartition(int[] nums) {
        //take total elements sum then try to half divide them 
        int n = nums.length;
        int sum=0;
        for(int num: nums)
        sum += num;

        if(sum%2 != 0) return false;

        int target = sum/2;
        boolean dp[][] = new boolean[n+1][target+1];

        dp[0][0] = true;
        
        for(int i=1; i<n; i++){
            dp[i][0] = true;
        }

        for(int j=1; j<target+1; j++){
            dp[0][j] = false;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<target+1; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        if(dp[n][target])
        return true;
        else
        return false;



    }
}