class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int graph[][] = new int[n][n];
        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        
        
        int count=0;
        boolean vis[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                int ver[] = new int[1];
                int edg[] = new int[1];
                dfs(i, vis, graph, ver, edg);
               // System.out.println(ver[0]+ " "+edg[0]);
                if(edg[0] == ((ver[0]*(ver[0]-1)))) count++;
            }
        }
        return count;
    }

    public void dfs(int curr, boolean vis[], int graph[][], int ver[], int edg[]){
        if(vis[curr]) return;

        vis[curr] = true;
        ver[0]++;


        for(int i=0; i<vis.length; i++){
            if(graph[curr][i]==1) edg[0]++;
            if(graph[curr][i] == 1 && !vis[i]){
                dfs(i, vis, graph, ver, edg);
            }
        }

    }
}