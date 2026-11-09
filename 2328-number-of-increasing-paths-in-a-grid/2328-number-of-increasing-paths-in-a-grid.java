class Solution {
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean vis[][] = new boolean[m][n];
        long ways[][] = new long[m][n];

        for(long a[]: ways){
            Arrays.fill(a, 1);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j]){
                    ways(grid, i, j, vis, ways);
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

    public int ways(int grid[][], int row, int col, boolean vis[][], long ways[][]){
        if(vis[row][col]) return (int)ways[row][col];
        vis[row][col]=true;

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        long way=ways[row][col];

        int d[][] = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        int curr = grid[row][col];

        for(int i=0; i<4; i++){
            int dr = row+d[i][0];
            int dc = col+d[i][1];

            if(dr>=0 && dr<m && dc>=0 && dc<n && curr < grid[dr][dc]){
                way += ways(grid, dr, dc, vis, ways);
                way %= MOD;
            }
        }
        ways[row][col]=way;

        return (int)way;
    }
}