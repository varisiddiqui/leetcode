class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int dp[][] = new int[n1+1][n2+1];

        dp[0][0] = 0;
        
        for(int i=1; i<n1+1; i++) dp[i][0] = i;

        for(int j=1; j<n2+1; j++) dp[0][j] = j;

        for(int i=1; i<n1+1; i++){
            for(int j=1; j<n2+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    
                    int min=Integer.MAX_VALUE;

                    //insert
                    min = Math.min(min, dp[i][j-1]);

                    //delete
                    min = Math.min(min, dp[i-1][j]);

                    //replace
                    min = Math.min(min, dp[i-1][j-1]);

                    dp[i][j] = min+1;


                }
            }
        } 

        return dp[n1][n2];
    }

    public int op(String word1, String word2, int i, int j, int dp[][]){
        if(j<0) return i+1;
        if(i<0) return j+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j]= op(word1, word2, i-1, j-1, dp);
        }
        
        int min=Integer.MAX_VALUE;

        //insert
        min = Math.min(min, op(word1, word2, i, j-1, dp));

        //delete
        min = Math.min(min, op(word1, word2, i-1, j, dp));

        //replace
        min = Math.min(min, op(word1, word2, i-1, j-1, dp));

        return dp[i][j] = min+1;
    }
}