import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int n = nums.length;
        Arrays.sort(nums);
        int op = 0;
        
        // Edge case: Already good
        if (nums[0] >= k) return op; 

        // Add smallest 2 elements initially
        long in = nums[0] * 2L + nums[1];
        pq.add(in);
        op++;

        int i = 2;

        while (i < n) {
            // FIX 1: Use Long.MAX_VALUE to prevent overflow comparisons
            long a = Long.MAX_VALUE; 
            long b = Long.MAX_VALUE;
            
            if (pq.size() >= 2) {
                a = pq.poll();
                b = pq.poll();
            } 
            else if (!pq.isEmpty()) {
                a = pq.poll();
            }

            // FIX 2: Cleaner exit condition. If the absolute smallest is >= k, we are done.
            if (Math.min(a, nums[i]) >= k) return op;

            if (a <= nums[i] && b <= nums[i]) {
                long insert = a * 2L + b;
                pq.add(insert);
                op++;
            } 
            else if (a <= nums[i]) {
                long insert = a * 2L + nums[i];
                i++;
                op++;
                if (b != Long.MAX_VALUE) pq.add(b);
                pq.add(insert); // FIX 3: Actually add the insert back!
            } 
            else if (i + 1 < n && a <= nums[i + 1]) {
                long insert = nums[i] * 2L + a;
                i++;
                op++;
                if (b != Long.MAX_VALUE) pq.add(b);
                pq.add(insert); // FIX 3
            } 
            else if (i + 1 < n) {
                long insert = nums[i] * 2L + nums[i + 1];
                i = i + 2;
                op++;
                if (a != Long.MAX_VALUE) pq.add(a);
                if (b != Long.MAX_VALUE) pq.add(b);
                pq.add(insert); // FIX 3
            } 
            else {
                // FIX 4: The missing edge case! 
                // We are at the last element (i + 1 == n) AND a > nums[i].
                // The two smallest are nums[i] and a.
                long insert = nums[i] * 2L + a;
                i++;
                op++;
                if (b != Long.MAX_VALUE) pq.add(b);
                pq.add(insert); 
            }
        }

        // Finish off whatever is left in the priority queue
        while (pq.size() >= 2 && pq.peek() < k) {
            long insert = pq.poll() * 2 + pq.poll();
            pq.add(insert);
            op++;
        }

        return op;
    }
}