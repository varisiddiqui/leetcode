class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        int dp[][] = new int[n1+1][n2+1];

        for(int i=1; i<n1+1; i++){
            for(int j=1; j<n2+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder str = new StringBuilder();
        int i=n1;
        int j=n2;

        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                str.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                    str.append(str1.charAt(i));
                }
                else{
                    j--;
                    str.append(str2.charAt(j));
                    
                }
            }
        }

        while(i>0){
            i--;
            str.append(str1.charAt(i));
            
        }
        while(j>0){
            j--;
            str.append(str2.charAt(j));
            
        }

        return str.reverse().toString();
    }
}