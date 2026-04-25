class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> frontMax = new PriorityQueue<>(Collections.reverseOrder());

        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> backMin = new PriorityQueue<>();

        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            backMin.add(num);
        }

        for(int i=0; i<n; i++){
            frontMax.add(nums[i]);
            int frontmax = frontMax.peek();
            int backmin = Integer.MAX_VALUE;

            while(!backMin.isEmpty() && (freq.get(backMin.peek()) <=0)){
                backMin.poll();
            }
            backmin = backMin.peek();

            if(freq.get(backmin) > 0){
                if(frontmax-backmin <= k) return i;

                freq.put(nums[i], freq.get(nums[i])-1);
            }
            
            
        }
        return -1;

    }
}