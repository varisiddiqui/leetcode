class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int n = nums.length;

        int dp[][] = new int[n+1][n];

        for(int i=0; i<n; i++)
        Arrays.fill(dp[i], -1);

        

        int ans = maxLength(-1,0,nums,dp);

        return ans;
    }

    public int maxLength(int prev_idx, int curr_idx, int nums[], int dp[][]){
        if(curr_idx >= nums.length)
        return 0;
        int max=0;

        if(dp[prev_idx+1][curr_idx] != -1) return dp[prev_idx+1][curr_idx];

        //valid
        
        if((prev_idx == -1) || (nums[curr_idx]>nums[prev_idx])){
            int take = 1+maxLength(curr_idx, curr_idx+1, nums,dp);
            int skip = maxLength(prev_idx, curr_idx+1, nums,dp);
            max = Math.max(take, skip);
        }
        else{
            
            int skip2 = maxLength(prev_idx, curr_idx+1, nums, dp);
            max = skip2;
        }
        return dp[prev_idx+1][curr_idx]=max;
    }
}


