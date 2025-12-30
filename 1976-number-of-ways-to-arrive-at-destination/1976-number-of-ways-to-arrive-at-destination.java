class Solution {
    static class Node{
        int des;
        int time;
        public Node(int des, int time){
            this.des = des;
            this.time = time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        @SuppressWarnings("unchecked")
        List<Node> graph[] = new ArrayList[n];
        
        Arrays.setAll(graph, i -> new ArrayList<>());

        for(int i=0; i<roads.length; i++){
            int src = roads[i][0];
            int des = roads[i][1];
            int time = roads[i][2];
            graph[src].add(new Node(des, time));
            graph[des].add(new Node(src, time));
        }

        long time[] = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        time[0]=0;

        Comparator<long[]> cmp = (a, b) -> {
            return Long.compare(a[0], b[0]);
        };

        PriorityQueue<long[]> pq = new PriorityQueue<>(cmp);

        pq.add(new long[]{0, 0});

        long ways[] = new long[n];
        ways[0]=1;
         int mod = 1_000_000_007;
        
        
        while(!pq.isEmpty()){
            long top[] = pq.remove();
            int curr = (int)top[1];
            long t = top[0];

            

            
            for(Node neigh: graph[curr]){
                if((t + neigh.time) < time[neigh.des]){
                    time[neigh.des] = t+neigh.time;
                    pq.add(new long[]{time[neigh.des], neigh.des});
                    ways[neigh.des] = ways[curr];
                }
                else if((t + neigh.time) == time[neigh.des]){
                    ways[neigh.des] = (ways[neigh.des]+ways[curr])%mod;
                }
            }
        }

       
        return (int)ways[n-1];
    
        
    }
}