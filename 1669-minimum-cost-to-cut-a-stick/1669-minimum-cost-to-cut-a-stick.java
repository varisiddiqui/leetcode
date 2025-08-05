class Solution {
    public int minCost(int n, int[] cuts) {
        int[] newCuts = new int[cuts.length + 2];
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;
        System.arraycopy(cuts, 0, newCuts, 1, cuts.length);
        Arrays.sort(newCuts);
        int dp[][] = new int[cuts.length+2][cuts.length+2];
        for(int i=0; i<cuts.length+2; i++)
        Arrays.fill(dp[i], -1);
        return mcm(0, newCuts.length-1, newCuts, dp);

    }

    public int mcm(int i, int j, int cuts[], int dp[][]){
        if(j-i ==1)
        return dp[i][j]=0;
        if(dp[i][j] != -1)
        return dp[i][j];

        int min = Integer.MAX_VALUE;

        for(int k=i+1; k<j; k++){
                int c1 = mcm(i, k, cuts, dp);
                int c2 = mcm(k, j, cuts, dp);
                int c3 = cuts[j]-cuts[i];
                min = Math.min(min, c1+c2+c3);
         }
            return dp[i][j]=min;
        }
        
    
}