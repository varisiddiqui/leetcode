class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean vis[] = new boolean[v];
        boolean pathVis[] = new boolean[v];
        boolean isSafe[] = new boolean[v];
        for(int i=0; i<v; i++){
            if(!vis[i]){
                dfs(i, graph, vis, pathVis, isSafe);
            }
        }
        List<Integer> li = new ArrayList<>();
        for(int i=0; i<v; i++){
            if(isSafe[i]) li.add(i);
        }
        return li;
     }

    public boolean dfs(int curr, int graph[][], boolean vis[], boolean pathVis[], boolean isSafe[]){
        vis[curr] = true;
        pathVis[curr] = true;
        isSafe[curr]=false;
        for(int i=0; i<graph[curr].length; i++){
            if(!vis[graph[curr][i]]){
                if(dfs(graph[curr][i], graph, vis, pathVis, isSafe))
                {
                    isSafe[curr] = false;
                    return true;
                }
            }
                else if(pathVis[graph[curr][i]]){
                    isSafe[curr] = false;
                    return true;
                }
            
        }

        isSafe[curr]=true;
        pathVis[curr]=false;
        return false;
    }
}