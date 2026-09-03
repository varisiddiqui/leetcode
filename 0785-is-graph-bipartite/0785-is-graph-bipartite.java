class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        boolean vis[] = new boolean[v];

        int color[] = new int[v];
        Arrays.fill(color, -1);

        for(int i=0; i<v; i++){
            if(!vis[i])            
                if(!isValid(i, vis, graph, color, 0)) return false;                
            }
            
        

        return true;

    }

    public boolean isValid(int curr, boolean vis[], int graph[][], int color[], int clr){
        vis[curr]=true;
        color[curr]=clr;

        for(int neigh: graph[curr]){
            if(!vis[neigh]){
                if(clr == 0){
                    if(!isValid(neigh, vis, graph, color, 1)) return false;
                }
                else if(clr == 1){
                    if(!isValid(neigh, vis, graph, color, 0)) return false;
                }
            }
            else{
                if(color[neigh] == clr) return false;
            }
        }

        return true;

    }
}