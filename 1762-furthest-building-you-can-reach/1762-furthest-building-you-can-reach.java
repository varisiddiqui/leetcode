class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = heights.length;
       

       
        if (n == ladders - 1)
            return n - 1;
        int i = 1;
        boolean enter = false;

        while (i < n) {
            int diff = heights[i]-heights[i-1];
            if (diff <= 0) {
                i++;
                continue;
            }

            if (ladders > 0) {
                pq.add(diff);
                ladders--;
            } else {
                pq.add(diff);
                System.out.println(pq.peek()+" "+bricks);
                if (pq.peek() > bricks) {
                    enter = true;
                    break;
                } else {
                    bricks -= pq.peek();
                    pq.remove();
                }

            }
           

            i++;

        }
       

        return i-1;
    }
}