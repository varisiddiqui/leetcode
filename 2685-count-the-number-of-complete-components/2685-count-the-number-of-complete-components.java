class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer> graph[] = new ArrayList[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            graph[a].add(b);
            graph[b].add(a);
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

    public void dfs(int curr, boolean vis[], List<Integer> graph[], int ver[], int edg[]){
        if(vis[curr]) return;

        vis[curr] = true;
        ver[0]++;


        for(int i=0; i<graph[curr].size(); i++){
             edg[0]++;
            if(!vis[graph[curr].get(i)]){
                dfs(graph[curr].get(i), vis, graph, ver, edg);
            }
        }

    }
}