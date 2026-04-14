class Solution {
    public long maxKelements(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        Arrays.sort(nums);
        int i=n-2;
        long score=nums[n-1];
        k--;
        pq.add((long)Math.ceil((double)nums[n-1]/(double)3));

        while(i>=0 && k>0){
            if(pq.peek() > nums[i]){
                score += pq.peek();
                k--;
                long top = (long)Math.ceil((double)pq.remove()/(double)3);
                pq.add(top);
            }
            else{
                score += nums[i];
                pq.add((long)Math.ceil((double)nums[i]/(double)3));
                i--;
                k--;
            }
        }
        while(k>0){
            score += pq.peek();
            k--;
            pq.add((long)Math.ceil((double)pq.poll()/(double)3));

        }
        return score;




    }
}