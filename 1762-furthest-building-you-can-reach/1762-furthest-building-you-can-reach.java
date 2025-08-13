class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = heights.length;
       

       
        if (n == ladders - 1)
            return n - 1;
        int i = 1;
      

        while (i < n) {
            int diff = heights[i]-heights[i-1];
            if (diff <= 0) {
                i++;
                continue;
            }

            pq.add(diff);

            if (pq.size() > ladders) {
                bricks -= pq.peek();
                pq.poll();
            } 
            if(bricks <0)
            return i-1;

            i++;

        }
       

        return n-1;
    }
}