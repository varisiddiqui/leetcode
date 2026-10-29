class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[] = new int[high+1];
        Arrays.fill(dp, -1);
        return ways(0, low, high, zero, one, dp);

    }

    public int ways(int curr_len, int low, int high, int zero, int one, int dp[]){
        if(curr_len > high) return 0;

        if(dp[curr_len] != -1) return dp[curr_len];

        int MOD = 1_000_000_007;
        int inRange = 0;

        if(curr_len >= low && curr_len <= high) inRange = 1;

        return dp[curr_len] = (ways(curr_len+one, low, high, zero, one, dp) + ways(curr_len+zero, low, high, zero, one, dp))%MOD+inRange;
    }
}