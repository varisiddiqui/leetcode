class Solution {
    public boolean canFinish(int v, int[][] grid) {
        @SuppressWarnings("unchecked")
        List<Integer> graph[] = new ArrayList[v];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for(int i=0; i<grid.length; i++){
            int src = grid[i][0];
            int des = grid[i][1];
            graph[src].add(des);
        }

        boolean vis[] = new boolean[v];
        boolean pathVis[] = new boolean[v];

        for(int i=0; i<v; i++){
            if(!vis[i]){
                if(isCycle(i, vis, pathVis, graph)) return false;
            }
        }
        return true;        
        
        
    }

    public boolean isCycle(int curr, boolean vis[], boolean pathVis[], List<Integer> graph[]){
        vis[curr] = true;
        pathVis[curr] = true;

        List<Integer> li = graph[curr];

        for(int i: li){
            if(!vis[i]){
                if(isCycle(i, vis, pathVis, graph)) return true;
            }
            else if(pathVis[i]) return true;
        }
        pathVis[curr] = false;
        return false;
    }
}