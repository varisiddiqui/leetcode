class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1] = 0;
        
        for(int i=n-2; i>=0; i--){
            int min = n+2;
            if(nums[i] == 0){
                continue;
            }
            for(int j=i+1; j<n && j<=i+nums[i]; j++){
                if(dp[j] != -1)
                min = Math.min(min, dp[j]);
            }
            if(min != n+2)
            dp[i] = min+1;
        }
        return dp[0];
    }
}