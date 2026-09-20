class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        int total = n*n;

        int par[] = new int[total];
        int size[] = new int[total];

        for(int i=0; i<total; i++){
            par[i] = i;
            size[i] = 1;
        }


        int d[][] = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int row = i;
                int col = j;

                if(grid[i][j] == 1){
                    int unique = row*n + col;
                    
                    for(int k=0; k<4; k++){
                        int dr = row + d[k][0];
                        int dc = col + d[k][1];

                        if(dr>=0 && dr<n && dc>=0 && dc<n && grid[dr][dc]==1){
                            int adj = dr*n + dc;
                            int par_curr = find(unique, par);
                            int par_adj = find(adj, par);

                            if(par_curr != par_adj){
                                union(par_curr, par_adj, size, par);
                            }
                        }
                    }
                }
            }
        }

        int max = largest(grid, par, size);

        Set<Integer> vis = new HashSet<>();

        for(int i=0; i<total; i++){
            max = Math.max(max, size[i]);
        }
        return max;

        

    }

    public int largest(int grid[][], int par[], int size[]){
        int maxSize = 1;
        int n = grid.length;

        int d[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    int row = i;
                    int col = j;

                    Set<Integer> adj_par = new HashSet<>();
                    for(int k=0; k<4; k++){
                        int dr = row + d[k][0];
                        int dc = col + d[k][1];

                       

                        if(dr>=0 && dr<n && dc>=0 && dc<n && grid[dr][dc]==1){
                            int unique = dr*n + dc;
                            adj_par.add(find(unique, par));
                        }
                    }

                    int curr_sz = 0;

                    for(int p: adj_par){
                        curr_sz += size[p];
                    }

                    maxSize = Math.max(maxSize, curr_sz+1);
                }
            }
        }

        return maxSize;
    }

    public void union(int x, int y, int size[], int par[]){
        int px = find(x, par);
        int py = find(y, par);

        if(px == py) return;

        if(size[px] < size[py]){
            par[px] = py;
            size[py] += size[px];
        }
        else {
            par[py] = px;
            size[px] += size[py];
        }
    }

    public int find(int x, int par[]){
        if(x == par[x]) return x;

        return par[x] = find(par[x], par);
    }
}