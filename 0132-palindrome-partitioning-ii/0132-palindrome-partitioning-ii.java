class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        
        for(int i=0; i<n; i++)
        Arrays.fill(dp[i], -1);

        boolean isPal[][] = buildPalindromeDP(s);
        if(isPal[0][n-1])
        return 0;
        return min(0, n-1, s, dp, isPal);
    }

    public static boolean[][] buildPalindromeDP(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        // length 1 substrings
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        // length 2 substrings
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
            }
        }

        // length >= 3 substrings
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                }
            }
        }

        return isPalindrome;
    }

    public int min(int i, int j, String s, int dp[][], boolean isPal[][]){
        String str = s.substring(i, j+1);
        if(i>=j || isPal[i][j]){
            return dp[i][j]=0;
        }

        if(dp[i][j] != -1)
        return dp[i][j];

        int min=Integer.MAX_VALUE;

        for(int k=i; k<j; k++){
            if(isPal[i][k]){
                int right = min(k+1, j, s, dp, isPal);
                min = Math.min(min, 1+right);
            }
            
        }
        if(min != Integer.MAX_VALUE)
        return dp[i][j]=min;
        return 0;
    }
}