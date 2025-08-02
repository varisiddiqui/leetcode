class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++)
        set.add(nums[i]);

        int sorted[] = new int[set.size()];
        int k=0;
        for(Integer num: set)
        sorted[k++]=num;

        Arrays.sort(sorted);
        int m = sorted.length;

        int dp[][] = new int[n+1][m+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                //if same
                if(nums[i-1] == sorted[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}