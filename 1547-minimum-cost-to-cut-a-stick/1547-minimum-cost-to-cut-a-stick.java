class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int l=cuts.length;

        int c[] = new int[l+2];
        for(int i=0; i<l; i++) c[i+1] = cuts[i];
        c[l+1] = n;


        int dp[][] = new int[l+2][l+2];
        for(int i=0; i<l+2; i++) Arrays.fill(dp[i], -1);
        return minC(0, l+1, c, dp);
    }

    public int minC(int i, int j, int c[], int dp[][]){
        if(i>=j) return 0;

        int minCost=Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];
        

        for(int k=i+1; k<j; k++){
           
                int leftCut = minC(i, k, c, dp);
                int rightCut = minC(k, j, c, dp);
                int totalCost = leftCut +  rightCut + c[j]-c[i];
                minCost = Math.min(minCost, totalCost);
            
        }
   
        return dp[i][j] = minCost==Integer.MAX_VALUE?0:minCost;
    }
}