class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int ans[][] = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int r = i;
                int c = j;
                for(int l = r-k; l<=r+k ; l++){
                    for(int ri=c-k; ri<=c+k ; ri++){
                        if(l>=0 && l<n && ri>=0 && ri<m)
                        ans[r][c] += mat[l][ri];
                    }
                }

            }
        }
        return ans;
    }
}