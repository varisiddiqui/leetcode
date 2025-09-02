class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        Comparator<int[]> cmp = (a, b) -> {
            return a[1] - b[1];
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);
        for(Integer key: hm.keySet()){
            pq.add(new int[]{key, hm.get(key)});
            if(pq.size()>k)
            pq.remove();
        }

        int ans[] = new int[k];
        int l=0;
        while(k-->0){
           ans[l++]=pq.peek()[0];
           pq.remove();
        }

        return ans;
        
    }
}