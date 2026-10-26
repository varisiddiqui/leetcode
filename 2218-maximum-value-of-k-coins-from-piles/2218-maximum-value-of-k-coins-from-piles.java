class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int maxSz=0;
        for(List<Integer> p: piles) maxSz = Math.max(maxSz, p.size());

        int dp[][][] = new int[n][maxSz][k+1];

        for(int a[][]: dp){
            for(int b[]: a) Arrays.fill(b, -1);
        } 


        return max(0, 0, k, piles, dp);
    }

    public int max(int curr_idx, int i, int k, List<List<Integer>> piles, int dp[][][]){
        if(k==0) return 0;

        if(k>0 && curr_idx == piles.size()) return Integer.MIN_VALUE;

        if(dp[curr_idx][i][k] != -1) return dp[curr_idx][i][k];

        int take=0;

        //pick
        if(i < piles.get(curr_idx).size()){
            take = piles.get(curr_idx).get(i);

            if(i+1 < piles.get(curr_idx).size()){
                take += max(curr_idx, i+1, k-1, piles, dp);
            }
            else take += max(curr_idx+1, 0, k-1, piles, dp);
    
        }

        int not_take = max(curr_idx+1, 0, k, piles, dp);

        return dp[curr_idx][i][k] = Math.max(take, not_take);
    }
}