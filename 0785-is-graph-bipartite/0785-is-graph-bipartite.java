class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
       
        boolean vis[] = new boolean[n];
        int color[] = new int[n];
        for(int i=0; i<n; i++){
            if(!vis[i]){
                if(!dfs(i, -1, graph, color, vis))
                return false;
            }
        }
        return true;
        
  }

  public boolean dfs(int curr, int par, int graph[][], int color[], boolean vis[]){
    if(par == -1){
        color[curr] = 1;
    }
    else if(color[par] == 1) color[curr]=2;
    else color[curr]=1;

    vis[curr]=true;
    for(int i=0; i<graph[curr].length; i++){
        if(!vis[graph[curr][i]]){
            if(!dfs(graph[curr][i], curr, graph, color, vis)) return false;
        }
        else if(vis[graph[curr][i]] && graph[curr][i] != par &&  color[graph[curr][i]] == color[curr]) return false;
    }
    return true;
  }
}