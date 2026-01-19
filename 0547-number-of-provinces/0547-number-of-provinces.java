class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;

        int par[] = new int[v];
        int sz[] = new int[v];

        for(int i=0; i<v; i++){
            par[i]=i;
            sz[i]=1;
        }

        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(isConnected[i][j] == 0) continue;
                if(find(par, i) == find(par, j)) continue;
                union(par, sz, i, j);
            }
        }

        Set<Integer> lead = new HashSet<>();

        for(int i=0; i<v; i++) lead.add(find(par, i));
        return lead.size();
    }

    static int find(int par[], int x){
        if(x == par[x]) return x;
        else return par[x] = find(par, par[x]);
    }

    static void union(int par[], int sz[], int x, int y){
        int leadX = find(par, x);
        int leadY = find(par, y);

        if(leadX == leadY) return;

        if(sz[leadX]>sz[leadY]){
            par[leadY] = leadX;
            sz[leadX] += sz[leadY];
        }
        else{
            par[leadX] = leadY;
            sz[leadY] += sz[leadX];
        }
    }
}