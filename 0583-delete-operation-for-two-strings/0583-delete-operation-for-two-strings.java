class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int dp[][] = new int[n1][n2];

        for(int i=0; i<n1; i++){
            Arrays.fill(dp[i], -1);
        }

        return min(word1, word2, 0, 0, dp);
    }

    public int min(String word1, String word2, int i, int j, int dp[][]){
        int n1 = word1.length();
        int n2 = word2.length();

        if(i >= n1){
            return (n2-j);
        }
        if(j >= n2){
            return (n1-i);
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = min(word1, word2, i+1, j+1, dp);
        }

        return dp[i][j] = 1+Math.min(min(word1, word2, i+1, j, dp), min(word1, word2, i, j+1, dp));
        
    }
}