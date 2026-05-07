class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums) pq.add(num);

        int i=0;

        while(!pq.isEmpty()){
            nums[i++] = pq.poll();
        }
        return nums;
    }
}