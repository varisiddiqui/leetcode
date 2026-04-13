import java.util.*;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        int i = 0;
        int j = n - 1;
        long sum = 0;

        // Note: We don't actually need the index in the PQ for this problem 
        // because the problem says if costs are equal, pick the smaller index.
        // Since pq1 always holds smaller indices than pq2, we just prioritize pq1.

        for (int count = 0; count < k; count++) {
            // Fill pq1 up to 'candidates' size, as long as it doesn't overlap with j
            while (pq1.size() < candidates && i <= j) {
                pq1.add(costs[i++]);
            }
            // Fill pq2 up to 'candidates' size, as long as it doesn't overlap with i
            while (pq2.size() < candidates && i <= j) {
                pq2.add(costs[j--]);
            }

            // Get the smallest values available, treat empty PQ as infinity
            int val1 = pq1.isEmpty() ? Integer.MAX_VALUE : pq1.peek();
            int val2 = pq2.isEmpty() ? Integer.MAX_VALUE : pq2.peek();

            if (val1 <= val2) {
                sum += pq1.poll();
            } else {
                sum += pq2.poll();
            }
        }

        return sum;
    }
}