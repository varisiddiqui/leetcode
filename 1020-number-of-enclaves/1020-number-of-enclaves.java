class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans=0;

        boolean vis[][] = new boolean[m][n];

        for(int i=0; i<m; i++){
            if(grid[i][0] == 1 && !vis[i][0]){
                dfs(i, 0, grid, vis);
            } 

            if(grid[i][n-1]==1 && !vis[i][n-1]){
                dfs(i, n-1, grid, vis);
            }
        }

        for(int j=1; j<n-1; j++){
            if(grid[0][j] == 1 && !vis[0][j]){
                dfs(0, j, grid, vis);
            }

            if(grid[m-1][j] == 1 && !vis[m-1][j]){
                dfs(m-1, j, grid, vis);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j] && grid[i][j]==1) ans++;
            }
        }
        return ans;


    }

    public void dfs(int i, int j, int grid[][], boolean vis[][]){
        int d[][] = {{0,-1}, {-1,0}, {0,1}, {1,0}};
        vis[i][j]=true;
        int m = grid.length;
        int n = grid[0].length;

        for(int k=0; k<4; k++){
            int row = d[k][0]+i;
            int col = d[k][1]+j;
            if(row>=0 && row<m && col>=0 && col<n && !vis[row][col] && grid[row][col]==1){
                dfs(row, col, grid, vis);
            }
        }
    }
}