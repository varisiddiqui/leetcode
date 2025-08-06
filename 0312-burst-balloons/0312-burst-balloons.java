class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length == 1)
        return nums[0];

        int a[] = new int[nums.length+2];
        a[0]=1;
        for(int i=0; i<nums.length; i++){
            a[i+1]=nums[i];
        }
        a[a.length-1]=1;
        
        int dp[][] = new int[a.length][a.length];
        int n = a.length;
        
        for(int i=0; i<n; i++)
        dp[i][i] = a[i];

        for(int i=n-1; i>=0; i--){
            for(int j=i+1; j<n; j++){
                int min = 0;
                for(int k=i+1; k<j; k++){
                    int c1 = a[i]*a[k]*a[j];
                    int c2 = dp[i][k];
                    int c3 = dp[k][j];
                    min = Math.max(min, c1+c2+c3);
                }
                dp[i][j]=min;
            }
        }

        return dp[0][n-1];
        
        
    }

   
}