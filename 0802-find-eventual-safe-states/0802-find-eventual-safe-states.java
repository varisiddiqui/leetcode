class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean vis[] = new boolean[v];
        boolean pathVis[] = new boolean[v];
        boolean safe[] = new boolean[v];

        for(int i=0; i<v; i++){
            if(!vis[i]){
                dfs(i, vis, pathVis, safe, graph);
            }
        }
        List<Integer> li = new ArrayList<>();

        for(int i=0; i<v; i++){
            if(safe[i]) li.add(i);
        }

        return li;

    }

    public boolean dfs(int curr, boolean vis[], boolean pathVis[], boolean safe[], int graph[][]){
        vis[curr] = true;
        pathVis[curr] = true;
        safe[curr] = false;

        for(int neigh: graph[curr]){
            if(!vis[neigh]){
                if(dfs(neigh, vis, pathVis, safe, graph)){
                    safe[curr] = false;
                    return true;
                }
            }
            else if(pathVis[neigh]){
                safe[neigh] = false;
                return true;
            }
        }

        safe[curr] = true;
        pathVis[curr] = false;
        return false;
    }
}