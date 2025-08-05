class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 1;
        }
        int dp[] = new int[n]; // lis
        int count[] = new int[n]; //ways to make lis including it
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        
        int max=1;
        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[i]>nums[j] && dp[i]<=dp[j]+1){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                        count[i]=count[j];
                    }
                    else{
                        count[i] += count[j];
                    }

                }
            }
            max = Math.max(max, dp[i]);
        }
        if(max == 1)
        return n;
        int ways=0;

        for(int i=0; i<n; i++){
            if(dp[i] == max)
            ways += count[i];

        }
        return ways;
     

    }
}