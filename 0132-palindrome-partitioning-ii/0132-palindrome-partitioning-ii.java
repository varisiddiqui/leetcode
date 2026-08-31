class Solution {
    int ans = Integer.MAX_VALUE;

    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        boolean isPal[][] = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                        (j - i <= 1 || isPal[i + 1][j - 1])) {

                    isPal[i][j] = true;
                }
            }
        }

        return part(0, s, dp, isPal) - 1;

    }

    public int part(int idx, String s, int dp[], boolean isPal[][]) {
        if (idx == s.length()) {
            return 0;
        }

        if (dp[idx] != -1)
            return dp[idx];

        int cuts = s.length() + 2;

        //if(dp[idx] != -1) return dp[i];

        for (int i = idx; i < s.length(); i++) {
            if (isPal[idx][i]) {

                //System.out.println(li);

                cuts = Math.min(cuts, 1 + part(i + 1, s, dp, isPal));

            }
        }
        return dp[idx] = cuts;
    }

}