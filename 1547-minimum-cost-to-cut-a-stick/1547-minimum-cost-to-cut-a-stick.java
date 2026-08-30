class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int l = cuts.length;

        int c[] = new int[l + 2];
        for (int i = 0; i < l; i++)
            c[i + 1] = cuts[i];
           c[l + 1] = n;

        int dp[][] = new int[l + 2][l + 2];

        for (int i = 0; i < l + 2; i++)
            dp[i][i] = 0;

        for (int i = l + 1; i >= 0; i--) {
            for (int j = i + 1; j < l + 2; j++) {
                int minCost = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {

                    int leftCut = dp[i][k];
                    int rightCut = dp[k][j];
                    int totalCost = leftCut + rightCut + c[j] - c[i];
                    minCost = Math.min(minCost, totalCost);
                }

                dp[i][j] = minCost==Integer.MAX_VALUE?0:minCost;
            }
        }
        return dp[0][l+1];
    }

    
}