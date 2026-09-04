class Solution {
    public List<Integer> eventualSafeNodes(int[][] g) {
        int v = g.length;

        @SuppressWarnings("unchecked")
        List<Integer> graph[] = new ArrayList[v];

        Arrays.setAll(graph, (i) -> new ArrayList<>());

        for(int i=0; i<v; i++){
            for(int neigh: g[i]){
                graph[i].add(neigh);
            }
        }
        
        boolean vis[] = new boolean[v];
        boolean pathVis[] = new boolean[v];
        
        

        for(int i=0; i<v; i++){
            if(!vis[i]){
                isCycle(i, graph, vis, pathVis);
            }
        }

        List<Integer> safe = new ArrayList<>();

        for(int i=0; i<v; i++){
            if(!pathVis[i]) safe.add(i);
        }

        return safe;

    }

    public boolean isCycle(int curr, List<Integer> graph[], boolean vis[], boolean pathVis[]){
        vis[curr]=true;
        pathVis[curr]=true;

        for(int neigh: graph[curr]){
            if(!vis[neigh]){
                if(isCycle(neigh, graph, vis, pathVis)){
                   
                    return true;
                }
            }
            else if(pathVis[neigh]){
               
                return true;
            }
            
            
        }
        //isSafe[curr]=true;
        pathVis[curr]=false;
        return false;
    }
}