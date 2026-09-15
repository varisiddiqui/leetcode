class Solution {
    public int countPaths(int n, int[][] roads) {
        @SuppressWarnings("unchecked")
        List<int[]> graph[] = new ArrayList[n];

        Arrays.setAll(graph, (i) -> new ArrayList<>());

        for(int edg[]: roads){
            int u = edg[0];
            int v = edg[1];
            int time = edg[2];

            graph[u].add(new int[]{v, time});
            graph[v].add(new int[]{u, time});
        }

        long time[] = new long[n];
        long dp[] = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);

        time[0]=0;
        dp[0]=1;

        Comparator<long[]> cmp = (a, b) -> {
            return Long.compare(a[0], b[0]);
        };

        PriorityQueue<long[]> pq = new PriorityQueue<>(cmp);

        pq.add(new long[]{0, 0}); // time, node

        //long ans = Long.MAX_VALUE;
        long minTime=Long.MAX_VALUE;

        while(!pq.isEmpty()){
            long top[] = pq.remove();
        

            long t = top[0];
            int node = (int)top[1];

            if(time[node] < t) continue;

            if(node == n-1){
                if(minTime > t){
                    minTime=t;
                }
                else if(minTime == t)
                continue;
            }

            for(int neigh[]: graph[node]){
                int next = neigh[0];
                int wt = neigh[1];

                if((t+wt) < time[next]){
                    time[next] = t+wt;
                    pq.add(new long[]{time[next], next});
                    dp[next]=dp[node];
                }
                else if((t+wt) == time[next]){
                    dp[next] += dp[node];

                    dp[next] %= (1_000_000_007);
                }
            }
        }

        return (int)(dp[n-1] % 1_000_000_007);
    }
}