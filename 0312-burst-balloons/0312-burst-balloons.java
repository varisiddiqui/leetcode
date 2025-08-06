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
        
        for(int i=0; i<a.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return max(0, a.length-1, a, dp);
        
        
    }

    public int max(int i, int j, int a[], int dp[][]){
        if(i == j)
        return dp[i][j] = a[i];

        if(dp[i][j] != -1)
        return dp[i][j];
        
        int max = 0;

        for(int k=i+1; k<j; k++){
            int cost1 = a[i]*a[k]*a[j];
            int cost2 = max(i, k, a, dp);
            int cost3 = max(k, j, a, dp);
            max = Math.max(max, cost1+cost2+cost3);
        }
        return dp[i][j]=max;
    }
}