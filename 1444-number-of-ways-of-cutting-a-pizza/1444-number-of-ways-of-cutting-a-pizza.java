class Solution {
    public int ways(String[] pizza, int k) {
        
        int row = pizza.length;
        int col = pizza[0].length();

        int apples[][] = new int[row][col];

        int dp[][][] = new int[row][col][k+1];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                for(int part=0; part<=k; part++) dp[i][j][part] = -1;
            }
        }

        for(int c=col-1; c>=0; c--){
            int colApp=0;
            for(int r=row-1; r>=0; r--){
                if(pizza[r].charAt(c) == 'A') colApp++;
                apples[r][c] += colApp;

                if(c+1<col){
                    apples[r][c] += apples[r][c+1];
                }
            }
        }
        if(k==1 && apples[0][0]>0) return 1; 

        return (int)wayCut(0, 0, k, apples, dp);



    }

    public long wayCut(int row, int col, int k, int apples[][], int dp[][][]){
       
        if(k==1 && apples[row][col] > 0) return 1;

         if(apples[row][col] < k) return 0;

         if(dp[row][col][k] != -1) return dp[row][col][k]; 

        long ways=0;
        int MOD = 1_000_000_007;
        

        //try all vertical cuts
        for(int vert=col; vert<apples[0].length-1; vert++){
            int left_apples = apples[row][col]-apples[row][vert+1];
            int right_apples = apples[row][vert+1];
            

            if(left_apples >= 1 && right_apples >= (k-1)){
                ways +=  wayCut(row, vert+1, k-1, apples, dp);
                ways %= MOD;
            }
        }

        //try all horizontal cuts
        for(int horz=row; horz<apples.length-1; horz++){
            int upper_apples = apples[row][col] - apples[horz+1][col];
            int lower_apples = apples[horz+1][col];

            if(upper_apples >= 1 && lower_apples >= k-1){
                ways +=  wayCut(horz+1, col, k-1, apples, dp);
                ways %= MOD;
            }
        }

        ways %= MOD;

        return dp[row][col][k] = (int)ways;
    }
}