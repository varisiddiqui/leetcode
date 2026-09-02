class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean vis[][] = new boolean[m][n];

        int islands=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    //System.out.println(islands);
                    bfs(i, j, vis, grid);
                    islands++;
                }
            }
        }

        return islands;


    }

    public void bfs(int r, int c, boolean vis[][], char grid[][]){
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        q.add(new int[]{r, c});
        vis[r][c] = true;
        int d[][] = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        while(!q.isEmpty()){
            int sz = q.size();

            

            for(int i=0; i<sz; i++){
                int top[] = q.remove();
                
                for(int j=0; j<4; j++){
                    int row = d[j][0]+top[0];
                    int col = d[j][1]+top[1];
                    
                    if(row>=0 && row<m && col>=0 && col<n && grid[row][col]=='1' && !vis[row][col]){
                        vis[row][col]=true;
                        q.add(new int[]{row, col});
                    }
                }

            }
        }
        
    }
}