class Solution {
    public int minDifficulty(int[] diff, int d) {
        int n = diff.length;

        int dp[][] = new int[n+1][d + 1];

        for (int i = 0; i < n+1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[n][0]=0;

        if (d > n)
            return -1;

        for (int st_idx = n-1 ; st_idx >= 0; st_idx--) {
            for (int rem_d = 1; rem_d <= Math.min(d, n - (st_idx)); rem_d++) {
                int max=0;
                for (int i = st_idx; i < n; i++) {
                    //System.out.print(i+" ");
                     max = Math.max(max, diff[i]);

                    if (rem_d - 1 >= 0 && rem_d - 1 <= n - (i + 1) && (dp[i+1][rem_d - 1] != Integer.MAX_VALUE)) {
                        dp[st_idx][rem_d] = Math.min(dp[st_idx][rem_d], max + dp[i+1][rem_d - 1]);
                    }
                }
            }
        }

        return dp[0][d];

    }

    
}