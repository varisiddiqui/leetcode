class Solution {
    static class Node{
        int des;
        int pr;
        public Node(int des, int pr){
            this.des = des;
            this.pr = pr;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        @SuppressWarnings("unchecked")
        List<Node> graph[] = new ArrayList[n];
        Arrays.setAll(graph, i -> new ArrayList<>());

        for(int i=0; i<flights.length; i++){
            int s = flights[i][0];
            int des = flights[i][1];
            int pr = flights[i][2];
            graph[s].add(new Node(des, pr));
        }
        k++;

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;

      
        Queue<int[]> pq = new LinkedList<>();

        pq.add(new int[]{0, src, 0});//dist, node, stops

        while(!pq.isEmpty()){
            int top[] = pq.remove();
            int curr = top[1];
            int stops = top[2];
            int d = top[0];

            //if(curr == dst) return d;

            if(stops+1 > k) continue;

            List<Node> li = graph[curr];

            for(Node neigh: li){
                int pr = neigh.pr;
                    if(stops+1 <= k && dist[neigh.des] > d+pr){
                        //if(dist[neigh.des] > d+pr){
                        dist[neigh.des] = d+pr;
                        //}
                        pq.add(new int[]{dist[neigh.des], neigh.des, stops+1});
                    }
                    
                    
                
            }            
        }

        return (dist[dst]==Integer.MAX_VALUE)? -1: dist[dst];

    }
}