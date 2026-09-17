class Solution {
    public int makeConnected(int n, int[][] connections) {
        Set<Integer> set = new HashSet<>();

        int rank[] = new int[n];
        int par[] = new int[n];

        for(int i=0; i<n; i++) par[i]=i;

        int extra = 0;

        for(int edg[]: connections){
            int x = edg[0];
            int y = edg[1];
            
            if(find(x, par) == find(y, par)){ // means they are already connected
                extra++;
                continue;
            }
            else {
                union(x, y, par, rank);
            }
        }

        for(int i=0; i<n; i++) set.add(find(i, par));

        return (extra >= set.size()-1)?set.size()-1: -1;

    
    }

    public void union(int x, int y, int par[], int rank[]){
        int px = find(x, par);
        int py = find(y, par);

        if(rank[px] == rank[py]){
            par[px] = py;
            rank[py]++;
        }
        else if(rank[px] < rank[py]){
            par[px] = py;
        }
        else {
            par[py] = px;
        } 
    }

    public int find(int x, int par[]){
        if(x == par[x]) return x;

        return par[x] = find(par[x], par);
    }
}