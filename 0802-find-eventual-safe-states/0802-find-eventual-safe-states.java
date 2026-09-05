class Solution {
    public List<Integer> eventualSafeNodes(int[][] g) {
        int v = g.length;

        @SuppressWarnings("unchecked")
        List<Integer> graph[] = new ArrayList[v];

        Arrays.setAll(graph, (i) -> new ArrayList<>());

        int indegree[] = new int[v];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<v; i++){
            for(int neigh: g[i]){
                graph[neigh].add(i);
                indegree[i]++;
            }
            if(indegree[i] == 0) q.add(i);
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);

            for(int neigh: graph[curr]){
                indegree[neigh]--;
                if(indegree[neigh] == 0) q.add(neigh);
            }
        }
        Collections.sort(ans);
        return ans;

        
    }
}