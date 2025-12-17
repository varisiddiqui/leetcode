class Solution {
    public int[] findOrder(int v, int[][] grid) {
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
        Stack<Integer> ans = new Stack<>();

        for(int i=0; i<v; i++){
            if(!vis[i]){
                if(isCycle(i, vis, pathVis, graph)) return new int[]{};
            }
        }
        vis = new boolean[v];
        for(int i=0; i<v; i++){
            if(!vis[i]){
                dfs(i, ans, vis, graph);
            }
        }

        int arr[] = new int[v];
        int k=v-1;
        while(!ans.isEmpty()){
            arr[k--] = ans.pop();
        }
        return arr;


               
    }

    public void dfs(int curr, Stack<Integer> ans, boolean vis[], List<Integer> graph[]){
        vis[curr] = true;
        List<Integer> li = graph[curr];
        for(int i=0; i<li.size(); i++){
            if(!vis[li.get(i)]){
                dfs(li.get(i), ans, vis, graph);
            } 
        }
        ans.add(curr);
    }

    public boolean isCycle(int curr, boolean vis[], boolean pathVis[], List<Integer> graph[]){
        vis[curr] = true;
        pathVis[curr] = true;

        List<Integer> li = graph[curr];

        for(int i=0; i<li.size(); i++){
            if(!vis[li.get(i)]){
                if(isCycle(li.get(i), vis, pathVis, graph)) return true;
            }
            else if(pathVis[li.get(i)]) return true;
        }
        pathVis[curr] = false;
        return false;
    }
}