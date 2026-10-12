class Solution {
    public int minDifficulty(int[] diff, int d) {
        int n = diff.length;

        int dp[][] = new int[n][d+1];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        if(d > n) return -1;

        return maxPart(0, d, diff, dp);


    }

    public int maxPart(int st_idx, int rem_d, int diff[], int dp[][]){
        int n = diff.length;
        if(st_idx == n) return 0;

        if(dp[st_idx][rem_d] != -1) return dp[st_idx][rem_d];

        int ans = Integer.MAX_VALUE;


        int max=diff[st_idx];

        for(int i=st_idx; i<n; i++){
            //System.out.print(i+" ");
            max = Math.max(max, diff[i]);

            if(rem_d-1>=0 && rem_d-1 <= n-(i+1)){
                ans = Math.min(ans, max + maxPart(i+1, rem_d-1, diff, dp));
            }
        }

        
        

        return dp[st_idx][rem_d] = (ans == Integer.MAX_VALUE)? max: ans;


    }
}