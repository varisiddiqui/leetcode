class Solution {
    
    public int makeConnected(int n, int[][] connections) {
        int par[] = new int[n];
        int sz[] = new int[n];

        for(int i=0; i<n; i++){
            par[i]=i;
            sz[i]=1;
        }
        int extra=0;

        for(int i=0; i<connections.length; i++){
            int x = connections[i][0];
            int y = connections[i][1];

            if(find(par, x) == find(par, y)){
                extra++;
                continue;
            }
            else{
                union(par, sz, x, y);
            }
        }

        int cnt=0;
        for(int i=0; i<n; i++){
            if(find(par, i) == i) cnt++;
        }

        return (extra<(cnt-1))?-1: cnt-1;
    }

    static int find(int par[], int x){
        if(x == par[x]) return x;
        else return par[x] = find(par, par[x]);
    }

    static void union(int par[], int sz[], int x, int y){
        int parX = find(par, x);
        int parY = find(par, y);

        if(parX == parY) {
           
            return;
        }

        if(sz[parX] < sz[parY]){
            par[parX] = parY;
            sz[parY] += sz[parX];
        }
        else{
            par[parY] = parX;
            sz[parX] += sz[parY];
        }
    }
}