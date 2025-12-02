class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int ans[][] = new int[n][m];

        int prefixSum[][] = new int[n][m];
        int prefixSum2[][] = new int[n][m];

        for(int i=0; i<n; i++){
            prefixSum[i][0] = mat[i][0];
            for(int j=1; j<m; j++){
                prefixSum[i][j] = prefixSum[i][j-1] + mat[i][j];
            }
        }

        for(int j=0; j<m; j++){
            prefixSum2[0][j] = mat[0][j];
            for(int i=1; i<n; i++){
                prefixSum2[i][j] = prefixSum2[i-1][j] + mat[i][j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int r = i; //row
                int c = j; //col
                int sum=0;
                for(int l = r-k; l<=r+k ; l++){
                    if(l<0 || l>=n) 
                    continue;


                    int left = Math.max(0, c-k);
                    int right = Math.min(m-1, c+k);

                   
                   

                    sum += (left == 0)? prefixSum[l][right]: prefixSum[l][right]-prefixSum[l][left-1];
                }
                ans[r][c] = sum;

            }
        }
        return ans;
    }
}