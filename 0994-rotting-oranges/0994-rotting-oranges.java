class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int min=0;

        //insert all rotten oranges once

        boolean vis[][] = new boolean[m][n];

        int count1=0;
        int actuall=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
                if(grid[i][j]==1) count1++;
            }
        }
        if(count1 == 0) return 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            min++;

            for(int i=0; i<sz; i++){
                int curr[] = q.remove();
                int row = curr[0];
                int col = curr[1];

                if(row+1 < m && grid[row+1][col] == 1 && !vis[row+1][col]){
                    vis[row+1][col] = true;
                    q.add(new int[]{row+1, col});
                    actuall++;
                }
                if(row-1 >= 0  && grid[row-1][col] == 1 && !vis[row-1][col]){
                    vis[row-1][col] = true;
                    q.add(new int[]{row-1, col});
                    actuall++;
                }
                if(col+1 < n && grid[row][col+1] == 1 && !vis[row][col+1]){
                    vis[row][col+1] = true;
                    q.add(new int[]{row, col+1});
                    actuall++;
                }
                if(col-1 >= 0 && grid[row][col-1] == 1 && !vis[row][col-1]){
                    vis[row][col-1] = true;
                    q.add(new int[]{row, col-1});
                    actuall++;
                }
            }
        }
        //System.out.println(actuall+" "+count1);

        if(actuall != count1) return -1;

        return min==1?0:min-1;
    }
}