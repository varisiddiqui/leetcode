class Solution {

    static class Pair {
        int des;
        int wt;

        public Pair(int des, int wt) {
            this.des = des;
            this.wt = wt;
        }
    }

    static class Node {
        int dist;
        int v;

        Node(int dist, int v) {
            this.dist = dist;
            this.v = v;
        }
    }

    public int networkDelayTime(int[][] edges, int v, int src) {
        @SuppressWarnings("unchecked")
        List<Pair>[] graph = new ArrayList[v+1];
        Arrays.setAll(graph, i -> new ArrayList<>());

        // build graph
        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int des = edges[i][1];
            int wt = edges[i][2];

            graph[s].add(new Pair(des, wt));
         
        }

        int[] dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // TreeSet comparator (distance first, node second)
        TreeSet<Node> set = new TreeSet<>(
                (a, b) -> a.dist != b.dist ? a.dist - b.dist : a.v - b.v);

        set.add(new Node(0, src));

        while (!set.isEmpty()) {

            Node top = set.pollFirst(); // smallest distance
            int s = top.v;

            for (Pair neigh : graph[s]) {

                if (dist[s] + neigh.wt < dist[neigh.des]) {

                    // remove old entry if exists
                    if (dist[neigh.des] != Integer.MAX_VALUE) {
                        set.remove(new Node(dist[neigh.des], neigh.des));
                    }

                    dist[neigh.des] = dist[s] + neigh.wt;
                    set.add(new Node(dist[neigh.des], neigh.des));
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