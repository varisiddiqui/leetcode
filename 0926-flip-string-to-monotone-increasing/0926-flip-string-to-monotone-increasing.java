class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();

        int dp[][] = new int[n][2];

        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);

        int ans=n+1;

        if(s.charAt(0) == '0'){
            ans = Math.min(ans, flips(1, 0, s, dp));
            ans = Math.min(ans, 1+flips(1, 1, s, dp));
        }
        else{
            ans = Math.min(ans, 1+flips(1, 0, s, dp));
            ans = Math.min(ans, flips(1, 1, s, dp));
        }
        return ans;


    }

    public int flips(int curr_idx, int prev, String s, int dp[][]){
        int n = s.length();
        if(curr_idx == n) return 0;

        if(dp[curr_idx][prev] != -1) return dp[curr_idx][prev];

        int ans = n+1;

        if(s.charAt(curr_idx) == '0'){//curr
            if(prev == 0){
                ans = Math.min(ans, 1 + flips(curr_idx+1, 1, s, dp));
                ans = Math.min(ans, flips(curr_idx+1, 0, s, dp));
            }
            else{
                ans = Math.min(ans, 1 + flips(curr_idx+1, 1, s, dp));
            }
        }
        else if(s.charAt(curr_idx) == '1'){//curr
            if(prev == 0){
                ans = Math.min(ans, flips(curr_idx+1, 1, s, dp));
                ans = Math.min(ans, 1 + flips(curr_idx+1, 0, s, dp));
            }
            else {
                ans = Math.min(ans, flips(curr_idx+1, 1, s, dp));
            }
        }

        return dp[curr_idx][prev] = ans;




    }
}