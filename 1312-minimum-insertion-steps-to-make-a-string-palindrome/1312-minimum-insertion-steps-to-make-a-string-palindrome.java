class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        int dp[][] = new int[n][n];

        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return minIn(s, 0, n-1, dp);


    }

    public int minIn(String s, int left, int right, int dp[][]){
        if(left >= right) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        if(s.charAt(left) == s.charAt(right)){
            return dp[left][right]=minIn(s, left+1, right-1, dp);
        }
        
        return dp[left][right] = 1+Math.min(minIn(s, left+1, right,dp), minIn(s, left, right-1,dp)); 
        

        
    }
}