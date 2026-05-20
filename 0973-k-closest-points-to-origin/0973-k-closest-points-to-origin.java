class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        Comparator<int[]> cmp = (a, b) -> {
            return a[0]-b[0];
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

        for(int i=0; i<n; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = (x*x)+(y*y);
            pq.add(new int[]{dist, x, y});
        }

        int ans[][] = new int[k][2];

        int j=0;
        while(j < k){
            ans[j][0]=pq.peek()[1];
            ans[j][1]=pq.peek()[2];
            j++;
            pq.poll();
        }
        return ans;
    }
}