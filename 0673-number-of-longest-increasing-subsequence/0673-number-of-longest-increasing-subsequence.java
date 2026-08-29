class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;

        int dp[]= new int[n];
        Arrays.fill(dp, 1);
        int max=0;

        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[j] < nums[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        int no[] = new int[n];
        no[0]=1;

        

        for(int i=1; i<n; i++){
            int req=dp[i]-1;
            if(req == 0) {
                no[i]++;
                continue;
            }
            for(int j=i-1; j>=0; j--){
                if(dp[j] == req && nums[j]<nums[i]) no[i] += no[j];
            }
        }

        int ans=0;

        for(int i=0; i<n; i++){
            if(dp[i] == max) ans += no[i];
        }
        return ans;


    }
}