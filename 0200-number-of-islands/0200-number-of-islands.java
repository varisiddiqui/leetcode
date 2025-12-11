class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean vis[][] = new boolean[r][c];
        int count=0;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, boolean vis[][], char graph[][]){
        if(graph[i][j] == '0' || vis[i][j]) return;

        vis[i][j]=true;

        if(i+1<graph.length)
        dfs(i+1, j, vis, graph);
        if(i-1>=0)
        dfs(i-1, j, vis, graph);
        if(j+1<graph[0].length)
        dfs(i, j+1, vis, graph);
        if(j-1>=0)
        dfs(i, j-1, vis, graph);
    }

    

}