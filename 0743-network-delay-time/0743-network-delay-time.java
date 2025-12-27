class Solution {

    static class Pair{
        int des;
        int wt;
        
        public Pair(int des, int wt){
            this.des = des;
            this.wt = wt;
        }
    }

    public int networkDelayTime(int[][] edges, int v, int src) {

        @SuppressWarnings("unchecked")
        List<Pair> graph[] = new ArrayList[v+1];

        Arrays.setAll(graph, i -> new ArrayList<>());
        
        for(int i=0; i<edges.length; i++){
            int s = edges[i][0];
            int des = edges[i][1];
            int wt = edges[i][2];
            
            graph[s].add(new Pair(des, wt));
            //graph[des].add(new Pair(s, wt));
        }
        
        int dist[] = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        
        Comparator<int[]> cmp = (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]);
        };
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);
        
        pq.add(new int[]{0, src});
        
        while(!pq.isEmpty()){
            int top[] = pq.remove();
            int s = top[1];
            
            List<Pair> li = graph[s];
            
            for(Pair neigh: li){
                if(dist[s]+neigh.wt < dist[neigh.des]){
                    dist[neigh.des] = dist[s]+neigh.wt;
                    pq.add(new int[]{dist[neigh.des], neigh.des});
                }
            }
            
        }
        
        int max = Integer.MIN_VALUE;

        for(int i=1; i<v+1; i++){
            int num = dist[i];
            if(num == Integer.MAX_VALUE) return -1;
            max = Math.max(max, num);
        }
        return max;
        
    }
}