class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        boolean vis[][] = new boolean[row][col];
        
        int ans=0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!vis[i][j] && grid[i][j]== '1'){
                    ans++;
                    dfs(i, j, grid, vis);
                }
            }
        }
        return ans;
    }

     public void dfs(int i, int j, char grid[][], boolean vis[][]){
        int row = grid.length;
        int col = grid[0].length;
        
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j]=='0' || vis[i][j]) return;
        
        vis[i][j]=true;
        
        
        dfs(i+1, j, grid, vis);
        dfs(i-1, j, grid, vis);
        dfs(i, j+1, grid, vis);
        dfs(i, j-1, grid, vis);
       
        
        
        
    }
}