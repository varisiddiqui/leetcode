class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] == 1 || grid[m-1][n-1]==1) return -1;

        boolean vis[][] = new boolean[m][n];

        vis[0][0]=true;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0,0});

        int level=0;

        int d[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
       

        while(!q.isEmpty()){
            int sz = q.size();
            level++;

            for(int i=0; i<sz; i++){
                
                int top[] = q.remove();
                int row = top[0];
                int col = top[1];

               // System.out.println(row+" "+col+" "+level);

                if(row == m-1 && col == n-1) return level;

                for(int j=0; j<8; j++){
                    int dr = row+d[j][0];
                    int dc = col+d[j][1];

                    if(dr>=0 && dr<m && dc>=0 && dc<n && !vis[dr][dc] && grid[dr][dc]==0){
                        q.add(new int[]{dr, dc});
                        vis[dr][dc]=true;
                    }
                }
            }
        }

        return -1;


    }
}