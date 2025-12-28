class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;
        int r = grid.length;
        int c = grid[0].length;

        //boolean vis[][] = new boolean[r][c];
        int dist[][] = new int[r][c];
        for (int i = 0; i < r; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        int dr[] = { 0, 0, -1, 1, -1, -1, 1, 1};
        int dc[] = { 1, -1, 0, 0, -1 , 1, -1, 1};

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { 0, 0 });
        //vis[source[0]][source[1]] = true;
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            int top[] = q.remove();
            int i = top[0];
            int j = top[1];
            int d = dist[i][j];
            for (int k = 0; k < dr.length; k++) {
                int nr = i + dr[k];
                int nc = j + dc[k];

                if (nr >= 0 && nr < r && nc >= 0 && nc < c && grid[nr][nc] == 0 && dist[nr][nc] == Integer.MAX_VALUE) {
                    q.add(new int[] { nr, nc });
                    dist[nr][nc] = d + 1;
                    if(nr== r-1 && nc == c-1) return d+1;
                }
            }

        }

        // for(int i=0; i<r; i++){
        //     for(int j=0; j<c; j++){
        //         System.out.print(dist[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        if (dist[r - 1][c - 1] == Integer.MAX_VALUE)
            return -1;
        else
            return dist[r - 1][c - 1];
    }
}