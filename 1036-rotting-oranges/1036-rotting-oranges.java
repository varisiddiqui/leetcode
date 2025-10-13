class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int ans[]= new int[1];
        int freshCount = 0;

        boolean vis[][] = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();

        // Add all rotten oranges to queue at once and count fresh oranges
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = true;
                } else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        // If no fresh oranges, return 0
        if(freshCount == 0) return 0;

        bfs(ans, q, grid, vis, freshCount);

        return ans[0];
    }

    public void bfs(int ans[], Queue<int[]> q, int grid[][], boolean vis[][], int freshCount){
        int row = grid.length;
        int col = grid[0].length;
        int rotted = 0;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int time = curr[2];
            
            ans[0] = Math.max(ans[0], time);

            // Check all 4 directions
            if((x+1<row) && grid[x+1][y]==1 && !vis[x+1][y]){
                vis[x+1][y] = true;
                q.add(new int[]{x+1, y, time+1});
                rotted++;
            }

            if((x-1>=0) && (grid[x-1][y]==1) && (!vis[x-1][y])){
                vis[x-1][y] = true;
                q.add(new int[]{x-1, y, time+1});
                rotted++;
            }

            if((y+1<col) && (grid[x][y+1]==1) && (!vis[x][y+1])){
                vis[x][y+1]=true;
                q.add(new int[]{x, y+1, time+1});
                rotted++;
            }

            if((y-1>=0) && (grid[x][y-1]==1) && (!vis[x][y-1])){
                vis[x][y-1]=true;
                q.add(new int[]{x, y-1, time+1});
                rotted++;
            }
        }
        
        // If not all fresh oranges were rotted, return -1
        if(rotted < freshCount) ans[0] = -1;
    }
}