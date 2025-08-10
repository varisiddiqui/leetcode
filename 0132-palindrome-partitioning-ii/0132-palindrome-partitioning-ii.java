class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean pal[][] = buildPalindromeDP(s);
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return min(0, s, pal, dp);

        
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

    public int min(int i, String str, boolean isPal[][], int dp[]){
        if(isPal[i][str.length()-1])
        return 0;
        if(dp[i] != -1)
        return dp[i];

        int minCost=Integer.MAX_VALUE;

        for(int j=i; j<str.length()-1; j++){
            if(isPal[i][j]){
                minCost = Math.min(minCost, 1+min(j+1, str, isPal, dp));
            }
        }
        return dp[i]=minCost;


    }
}