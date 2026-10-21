class Solution {
    public int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int n = s.length;
        int dp[][] = new int[n][n+1];

        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return maxSum(0, 1, s, dp);

    }

    public int maxSum(int curr_idx, int time, int s[], int dp[][]){
        if(curr_idx == s.length) return 0;

        if(dp[curr_idx][time] != -1) return dp[curr_idx][time];

        //pick 
        int pick = (s[curr_idx]*time) + maxSum(curr_idx+1, time+1, s, dp);

        //not pick
        int not_pick = maxSum(curr_idx+1, time, s, dp);

        return dp[curr_idx][time] = Math.max(pick, not_pick);

    }
}