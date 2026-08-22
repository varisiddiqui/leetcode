class Solution {
    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        boolean dp[][] = new boolean[n1+1][n2+1];

        dp[0][0] = true;

        for(int j=1; j<n2+1; j++){
            if(p.charAt(j-1) == '*') dp[0][j]=true;
            else break;
        }

        for(int i=1; i<n1+1; i++){
            for(int j=1; j<n2+1; j++){
                if(s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    if(p.charAt(j-1) == '?') dp[i][j] = dp[i-1][j-1];
                    if(p.charAt(j-1) == '*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }

        return dp[n1][n2];
    }

    public int isMat(String s, String p, int i, int j, int dp[][]){
       
        if(i==-1 && j==-1) return 1;
        if(j<0) return 0;
        if(i<0){
            for(int k=0; k<=j; k++){
                if(p.charAt(k) != '*') return 0;
            }
            return 1;
        }
        

        
    

        if(dp[i][j] != -1) return dp[i][j];



        if(s.charAt(i) == p.charAt(j)){
            return dp[i][j]=isMat(s, p, i-1, j-1, dp);
        }
    
            if(p.charAt(j) == '?'){
                return dp[i][j]=isMat(s, p, i-1, j-1, dp);
            }
            else if(p.charAt(j) == '*'){
                if(isMat(s, p, i, j-1, dp)==1) return dp[i][j]=1; 
                if(isMat(s, p, i-1, j, dp)==1) return dp[i][j]=1;
            }
            return dp[i][j]=0;

        

            
           
        
    }
}