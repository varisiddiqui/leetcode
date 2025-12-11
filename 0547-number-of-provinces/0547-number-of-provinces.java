class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;

        int res=0;
        boolean vis[] = new boolean[v];

        for(int i=0; i<v; i++){
            if(!vis[i]){
                res++;
                dfs(i, vis, isConnected);
            }
        }
        return res;

    }

    public void dfs(int curr, boolean vis[], int isC[][]){
        if(vis[curr]) return;

        vis[curr] = true;

        for(int j=0; j<vis.length; j++){
            if(isC[curr][j] == 1 && !vis[j]){
                dfs(j, vis, isC);
            }
        }
    }
}