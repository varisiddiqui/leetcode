class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean vis[][] = new boolean[r][c];
        int ans = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, grid, vis);
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] vis) {
        int r = grid.length;
        int c = grid[0].length;

        vis[i][j] = true;

        // Directions: up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];

            if (ni >= 0 && nj >= 0 && ni < r && nj < c && 
                !vis[ni][nj] && grid[ni][nj] == '1') {
                dfs(ni, nj, grid, vis);
            }
        }
    }
}