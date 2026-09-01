class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        
        List<Integer> graph[] = new ArrayList[n];

        Arrays.setAll(graph, (i) -> new ArrayList<>());

        for(int i=0; i<n; i++){
            int curr = i;
            for(int j=0; j<n; j++){
                int neigh = j;
                if(isConnected[i][j] == 1){
                    graph[curr].add(neigh);
                }
            }
        }

        int prv=0;
        boolean vis[] = new boolean[n];
        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(graph, vis, i);
                prv++;
            }
        }
        return prv;


    }

    public void dfs(List<Integer> graph[], boolean vis[], int curr){
        vis[curr] = true;

        for(int neigh: graph[curr]){
            if(!vis[neigh]){
                dfs(graph, vis, neigh);
            }
        }
    }
}