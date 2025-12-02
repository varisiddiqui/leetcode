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
            prefixSum2[0][j] = prefixSum[0][j];
            for(int i=1; i<n; i++){
                prefixSum2[i][j] = prefixSum2[i-1][j] + prefixSum[i][j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int r = i; //row
                int c = j; //col

                int left = Math.max(0, c-k);
                int right = Math.min(m-1, c+k);

                int up = Math.max(0, r-k);
                int down = Math.min(n-1, r+k);
                int sum=0;

                if(left == 0){
                    if(up == 0){
                        sum += prefixSum2[down][right];
                    }
                    else{
                        sum += prefixSum2[down][right]-prefixSum2[up-1][right];
                    }
                }
                else{
                    if(up == 0){
                        sum += prefixSum2[down][right] - prefixSum2[down][left-1];
                    }
                    else{
                        sum += (prefixSum2[down][right] - prefixSum2[down][left-1]) - (prefixSum2[up-1][right]-prefixSum2[up-1][left-1]);
                    }

                }

                ans[r][c] = sum;
                

            }
        }
        return ans;
    }
}