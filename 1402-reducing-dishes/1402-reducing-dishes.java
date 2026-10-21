class Solution {
    public int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int n = s.length;
        int dp[][] = new int[n+1][n+2];


        for(int curr_idx=n-1; curr_idx>=0; curr_idx--){
            for(int time=1; time<=n; time++){
                dp[curr_idx][time] = Math.max(dp[curr_idx][time], s[curr_idx]*time+dp[curr_idx+1][time+1]);

                dp[curr_idx][time] = Math.max(dp[curr_idx][time], dp[curr_idx+1][time]);
            }
        }

      
        return dp[0][1];

    }

    
}