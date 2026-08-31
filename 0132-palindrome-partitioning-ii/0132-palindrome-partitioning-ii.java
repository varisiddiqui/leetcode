class Solution {
    int ans=Integer.MAX_VALUE;
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        boolean isPal[][] = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPal(i, j, s)) isPal[i][j] = true;
                else isPal[i][j] = false;
            }
        }

        return part(0, s, dp, isPal)-1;
        
        
    }

    public int part(int idx, String s, int dp[], boolean isPal[][]){
        if(idx == s.length()){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        int cuts=s.length()+2;
        
        //if(dp[idx] != -1) return dp[i];

        for(int i=idx; i<s.length(); i++){
            if(isPal[idx][i]){
                
               //System.out.println(li);
                
               cuts = Math.min(cuts, 1+part(i+1, s, dp, isPal));
                
            }
        }
        return dp[idx] = cuts;
    }

    public boolean isPal(int st, int end, String s){
        while(st < end){
            if(s.charAt(st) != s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }
}