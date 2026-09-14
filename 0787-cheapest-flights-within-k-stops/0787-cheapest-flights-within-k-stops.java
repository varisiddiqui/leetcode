class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        @SuppressWarnings("unchecked")
        List<int[]> graph[] = new ArrayList[n];

        Arrays.setAll(graph, (i) -> new ArrayList<>());

        for(int edg[]: flights){
            graph[edg[0]].add(new int[]{edg[1], edg[2]});
        }

        int price[] = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 1});

        int ans = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int top[] = q.remove();

            int node = top[0];
            int priceFromSrc = top[1];
            int stop = top[2];

            if(node == dst){
                ans = Math.min(ans, priceFromSrc);
                continue;
            }

            for(int edg[]: graph[node]){
                int next = edg[0];
                int wt = edg[1];

                if(stop+1 <= k+2 && priceFromSrc+wt < price[next]){
                    price[next] = priceFromSrc+wt;
                    q.add(new int[]{next, price[next], stop+1});
                }
            }
        }

       
        return ans==Integer.MAX_VALUE?-1: ans;





        
    }
}