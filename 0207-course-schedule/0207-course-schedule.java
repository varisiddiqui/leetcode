class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        @SuppressWarnings("unchecked")
        List<Integer> graph[] = new ArrayList[n];

        Arrays.setAll(graph, (i) -> new ArrayList<>());

        for(int edg[]: prerequisites){
            int u = edg[0];
            int v = edg[1];
            graph[u].add(v);
        }

        boolean vis[] = new boolean[n];
        boolean pathVis[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                if(isCycle(i, graph, vis, pathVis)) return false;
            }
        }
        return true;
    }

    public boolean isCycle(int curr, List<Integer> graph[], boolean vis[], boolean pathVis[]){
        vis[curr]=true;
        pathVis[curr]=true;

        for(int neigh: graph[curr]){
            if(!vis[neigh]){
                if(isCycle(neigh, graph, vis, pathVis)) return true;
            }
            else if(pathVis[neigh]) return true;
        }

        pathVis[curr]=false;
        return false;
    }
}