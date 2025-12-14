class Solution {
    public int numEnclaves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean vis[][] = new boolean[r][c];

        for(int i=0; i<r; i++){
            if(!vis[i][0] && grid[i][0] == 1){
                dfs(i, 0, vis, grid);
            }
            if(!vis[i][c-1] && grid[i][c-1]==1){
                dfs(i, c-1, vis, grid);
            }
        }

        for(int j=0; j<c; j++){
            if(!vis[0][j] && grid[0][j]==1){
                dfs(0, j, vis, grid);
            }
            if(!vis[r-1][j] && grid[r-1][j]==1){
                dfs(r-1, j, vis, grid);
            }
        }

        int ans=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(!vis[i][j] && grid[i][j] == 1) ans++;
            }
        }
        return ans;
    }

    public void dfs(int i, int j, boolean vis[][], int grid[][]){
          int r = grid.length;
        int c = grid[0].length;
        vis[i][j] = true;

        if(i+1<r && !vis[i+1][j] && grid[i+1][j]==1){
            dfs(i+1, j, vis, grid);
        }

        if(i-1>=0 && !vis[i-1][j] && grid[i-1][j]==1){
            dfs(i-1, j, vis, grid);
        }

        if(j+1<c && !vis[i][j+1] && grid[i][j+1]==1){
            dfs(i, j+1, vis, grid);
        }

        if(j-1>=0 && !vis[i][j-1] && grid[i][j-1]==1){
            dfs(i, j-1, vis, grid);
        }
    }
}