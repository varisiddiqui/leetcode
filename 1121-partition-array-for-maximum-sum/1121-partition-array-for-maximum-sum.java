class Solution {
    public int maxSumAfterPartitioning(int[] arr, int l) {
        int n = arr.length;
        if(n==1)
        return arr[0];
        int dp[][] = new int[n][n]; 
        
        
        

        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                int max=0;

                if(j-i+1 <= l){
                    for(int t=i; t<=j; t++)
                        max = Math.max(max, arr[t]);
                        dp[i][j]=(j-i+1)*max;
                 }  

                 else{
                    int localmax=0;
                    for(int k=i; k<i+l; k++){
                        localmax=Math.max(localmax, arr[k]);
                            
                             int left = (k-i+1)*localmax;
                             int right = dp[k+1][j];
                             int sum = left+right;
                             max = Math.max(max, sum);
                        }
                        dp[i][j]=max;
                 } 

            }
        }

        return dp[0][n-1];
        




    }

    
}