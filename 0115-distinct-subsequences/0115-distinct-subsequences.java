class Solution {
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        int dp[][] = new int[n1+1][n2+1];

        for(int i=0; i<n1; i++) Arrays.fill(dp[i], -1);

        return subseq(s, t, s.length()-1, t.length()-1, dp);
    }

    public int subseq(String s, String t, int i, int j, int dp[][]){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j]= (subseq(s, t, i-1, j, dp)+subseq(s, t, i-1, j-1, dp));
        }
        
        return dp[i][j]=subseq(s, t, i-1, j, dp);

    }
}