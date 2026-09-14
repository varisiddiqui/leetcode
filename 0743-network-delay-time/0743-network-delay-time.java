class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        @SuppressWarnings("unchecked")
        List<int[]> graph[] = new ArrayList[n+1];

        Arrays.setAll(graph, (i) -> new ArrayList<>());
        
        for(int edg[]: times){
            graph[edg[0]].add(new int[]{edg[1], edg[2]});
        }

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(a[0], b[0]);
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

        int time[] = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k]=0;

        pq.add(new int[]{0, k}); // time, node

        while(!pq.isEmpty()){
            int top[] = pq.remove();

            int timeFromK = top[0];
            int node = top[1];

            for(int edg[]: graph[node]){
                int next = edg[0];
                int wt = edg[1];

                if(timeFromK+wt < time[next]){
                    time[next] = timeFromK+wt;
                    pq.add(new int[]{time[next], next});
                }
            }
        }

        int ans = 0;

        for(int i=1; i<n+1; i++) ans = Math.max(ans, time[i]);

        return ans==Integer.MAX_VALUE? -1: ans;

    }
}