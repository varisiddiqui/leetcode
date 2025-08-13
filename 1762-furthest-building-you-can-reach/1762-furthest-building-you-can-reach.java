class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = heights.length;
        int diff[] = new int[n];
        for (int i = 1; i < n; i++) {
            diff[i] = heights[i] - heights[i - 1];
        }

       
        if (n == ladders - 1)
            return n - 1;
        int i = 0;
        boolean enter = false;

        while (i < n) {
            if (diff[i] <= 0) {
                i++;
                continue;
            }

            if (ladders > 0) {
                pq.add(diff[i]);
                ladders--;
            } else {
                pq.add(diff[i]);
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