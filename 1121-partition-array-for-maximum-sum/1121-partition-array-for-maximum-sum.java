class Solution {
    public int maxSumAfterPartitioning(int[] arr, int l) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++)
        Arrays.fill(dp[i], -1);
        return maxSum(0, n-1, arr, l, dp);
    }

    public int maxSum(int i, int j, int arr[], int l, int dp[][]){
        int max=0;
        if(i>j)
        return dp[i][j]=0;

        if(dp[i][j] != -1)
        return dp[i][j];

        if(j-i+1 <= l){
            for(int t=i; t<=j; t++)
            max = Math.max(max, arr[t]);

            return dp[i][j]=(j-i+1)*max;
        }     

        int localmax=0;
        for(int k=i; k<i+l; k++){
            localmax = Math.max(localmax, arr[k]);
        
            int left = (k-i+1)*localmax;
            int right = maxSum(k+1, j, arr, l, dp);
            int sum = left+right;
            max = Math.max(max, sum);
        }
        return dp[i][j] = max;


    }
}