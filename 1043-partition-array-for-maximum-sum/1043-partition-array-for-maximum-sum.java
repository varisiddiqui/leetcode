class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return part(0, arr, k, dp);
    }

    public int part(int idx, int arr[], int k, int dp[]){
        if(idx == arr.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        int sum=0;
        int max=0;

        for(int i=idx; i<idx+k && i<arr.length; i++){
            max = Math.max(max, arr[i]);
            sum = Math.max(sum, max*(i-idx+1) + part(i+1, arr, k, dp));
        }
        return dp[idx]=sum;
    }
}