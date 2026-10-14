class Solution {
    static int sq[] = new int[100];

    static {
        for(int i=1; i<=100; i++){
            sq[i-1]= i*i;
        }
    }

    
    public int numSquares(int n) {
        //find index till which it can be limited
     

        int limit = bin(sq, n);
        System.out.println(limit);

        int dp[][] = new int[limit+2][n+1];

        //dp[i][j] = least number of perfect sq considering till ith index to sum j

        for(int i=0; i<limit+2; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        for(int i=0; i<limit+2; i++) dp[i][0]=0;

        for(int i=1; i<limit+2; i++){
            for(int j=1; j<n+1; j++){
                //invalid
                dp[i][j] = dp[i-1][j];

                //valid
                if(sq[i-1] <= j){
                    dp[i][j] = Math.min(dp[i][j], 1+dp[i][j-sq[i-1]]);
                }
            }
        }

        return dp[limit+1][n];
    }

    public int bin(int sq[], int key){
        int n = sq.length;

        int low = 0;
        int high = n-1;

        int ans = n-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(sq[mid] >= key){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }

        return ans;
    }
}