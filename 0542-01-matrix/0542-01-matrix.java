class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans[][] = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        boolean vis[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0 && !vis[i][j]) {
                    q.add(new int[] { i, j });
                    vis[i][j] = true;
                }
            }
        }

        int level = 0;
        int d[][] = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

        while (!q.isEmpty()) {
            int sz = q.size();
            level++;

            for (int i = 0; i < sz; i++) {
                int curr[] = q.remove();
                for (int j = 0; j < 4; j++) {
                    
                    int row = d[j][0] + curr[0];
                    int col = d[j][1] + curr[1];

                    if (row >= 0 && row < m && col >= 0 && col < n && !vis[row][col]) {
                        if (mat[row][col] == 1) {
                            ans[row][col] = level;
                        }
                        vis[row][col] = true;
                        q.add(new int[] { row, col });
                    }
                }
            }
        }

        return ans;
    }
}