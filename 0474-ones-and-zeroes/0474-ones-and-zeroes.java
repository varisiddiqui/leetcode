class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int l = strs.length;

        int count[][] = new int[l][2];

        for(int i=0; i<l; i++){
            int zero=0;
            int one=0;
            for(char ch: strs[i].toCharArray()){
                if(ch == '0') zero++;
                else one++;
            }
            count[i][0]=zero;//zero
            count[i][1]=one;//one
        }

        int dp[][][] = new int[l][m+1][n+1];

        for(int a[][]: dp){
            for(int b[]: a){
                Arrays.fill(b, -1);
            }
        }

        return maxLen(0, count, m, n, dp);
        
    }

    public int maxLen(int curr_idx, int count[][], int m, int n, int dp[][][]){
        if(curr_idx == count.length) return 0;

        if(dp[curr_idx][m][n] != -1) return dp[curr_idx][m][n];
        



        int take=0;

        //check validity
        if(m >= count[curr_idx][0] && n >= count[curr_idx][1]){
            take = 1 + maxLen(curr_idx+1, count, m-count[curr_idx][0], n-count[curr_idx][1], dp);
        } 

        int skip = maxLen(curr_idx+1, count, m, n, dp);

        return dp[curr_idx][m][n]=Math.max(take, skip);
    }
}