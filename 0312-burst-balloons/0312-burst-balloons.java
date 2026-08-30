class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int num[] = new int[n+2];
        num[0]=1;
        num[n+1]=1;

        int dp[][] = new int[n+2][n+2];

        for(int i=0; i<n; i++) num[i+1] = nums[i];

        for(int i=0; i<n+2; i++) Arrays.fill(dp[i], -1);

        return maxC(1, n, num, dp);

    }

    public int maxC(int i, int j, int num[], int dp[][]){
        if(i>j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int maxCoins=0;

        for(int k=i; k<=j; k++){
            int left = maxC(i, k-1, num, dp);
            int right = maxC(k+1, j, num, dp);
            int cost = num[i-1]*num[k]*num[j+1];
            maxCoins = Math.max(maxCoins, left+right+cost); 
        }

        return dp[i][j] = maxCoins;
    }
}