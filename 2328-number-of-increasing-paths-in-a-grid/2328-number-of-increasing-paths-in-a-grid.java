class Solution {
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //boolean vis[][] = new boolean[m][n];
        long ways[][] = new long[m][n];

        

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(ways[i][j] == 0){
                    ways(grid, i, j, ways);
                }
            }
        }

        long ans=0;
         int MOD = 1_000_000_007;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans += ways[i][j];
                ans %= MOD;
            }
        }

        return (int)ans;


    }

    public int ways(int grid[][], int row, int col, long ways[][]){
        if(ways[row][col] != 0) return (int)ways[row][col];
     

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        long way=1;

        int d[][] = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        int curr = grid[row][col];

        for(int i=0; i<4; i++){
            int dr = row+d[i][0];
            int dc = col+d[i][1];

            if(dr>=0 && dr<m && dc>=0 && dc<n && curr < grid[dr][dc]){
                way += ways(grid, dr, dc, ways);
                way %= MOD;
            }
        }
        ways[row][col]=way;

        return (int)way;
    }
}