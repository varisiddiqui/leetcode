class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;

        int dp[]= new int[n];
        int countWays[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(countWays, 1);

        int max=0;
        int ans=0;

        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[j] < nums[i] && dp[i] <= dp[j]+1){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                        countWays[i] = countWays[j];
                    }
                    else if(dp[i] == dp[j]+1){
                        countWays[i] += countWays[j];
                    }
                }
            }
            if(max < dp[i]){
                max = dp[i];
                ans = countWays[i];
            }
            else if(max == dp[i]){
                ans += countWays[i];
            }
            
        }
        if(dp[0] == max) ans++;

        
        

        
        return ans;


    }
}