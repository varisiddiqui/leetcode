class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n1=str1.length();
        int n2=str2.length();

        int dp[][] = new int[n1+1][n2+1];

        for(int i=1; i<n1+1; i++){
            for(int j=1; j<n2+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int i=n1, j=n2;
        StringBuilder str = new StringBuilder("");
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                str.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                str.append(str1.charAt(i-1));
                i--;
            }
            else{
                str.append(str2.charAt(j-1));
                j--;
            }
        }

        while(i>0){
            str.append(str1.charAt(i-1));
            i--;
        }

        while(j>0){
            str.append(str2.charAt(j-1));
            j--;
        }

        return str.reverse().toString();
    


    }
}