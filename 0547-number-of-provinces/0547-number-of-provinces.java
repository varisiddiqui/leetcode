class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean vis[] = new boolean[V];
        int ans=0;

        for(int i=0; i<V; i++){
            if(!vis[i]){
                ans++;
                dfs(i, isConnected, vis);
            }
        }
        return ans;


    }

    static void dfs(int start, int[][] isConnected, boolean vis[]){
        vis[start] = true;

        for(int i=0; i<isConnected[start].length; i++){
            if(isConnected[start][i] == 1 && !vis[i]){
                dfs(i, isConnected, vis);
            }
        }
    }
}