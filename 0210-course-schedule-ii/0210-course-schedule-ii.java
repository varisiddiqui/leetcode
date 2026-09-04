class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int ans[] = new int[n];
        
        @SuppressWarnings("unchecked")
        List<Integer> graph[] = new ArrayList[n];

        Arrays.setAll(graph, (i) -> new ArrayList<>());

        for(int edg[]: prerequisites){
            int u = edg[1];
            int v = edg[0];
            graph[u].add(v);
        }

        boolean vis[] = new boolean[n];
        boolean pathVis[] = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            if(!vis[i]){
                if(isCycle(i, graph, vis, pathVis, st)) return new int[]{};
            }
        }

        int k=0;
        
        while(!st.isEmpty()){
            ans[k++]=st.pop();
        }
        return ans;


        
    }

    public boolean isCycle(int curr, List<Integer> graph[], boolean vis[], boolean pathVis[], Stack<Integer> st){
        vis[curr]=true;
        pathVis[curr]=true;

        for(int neigh: graph[curr]){
            if(!vis[neigh]){
                if(isCycle(neigh, graph, vis, pathVis, st)){
                    return true;
                }
            }
            else if(pathVis[neigh]){
                    return true;
                }
        }

        pathVis[curr]=false;
        st.push(curr);
        return false;
    }
}