class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;

        long sum = 0;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);

        dp[0] = 1;
        long h = 1;

        for (int i = 1; i < n; i++) {
            h = Math.max(h, depth(i, parent, dp));
        }

        for (int i = 0; i < n; i++) {
            sum += (long)nums[i] * (h - dp[i] + 1);
        }

        return sum;
    }

    public long depth(int node, int parent[], long dp[]){
        if(dp[node] != -1) return dp[node];

        return dp[node] = depth(parent[node], parent, dp)+1;
    }
}