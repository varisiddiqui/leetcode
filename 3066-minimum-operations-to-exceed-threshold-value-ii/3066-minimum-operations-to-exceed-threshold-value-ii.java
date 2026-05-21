class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int num: nums) pq.add((long)num);

        int op=0;

        while(pq.size()>=2 && pq.peek()<k){
            long x = pq.poll();
            long y = pq.poll();

            long cal = Math.min(x, y)*2+ Math.max(x, y);
            pq.add(cal);
            op++;
        }

        return op;
        


    }
}