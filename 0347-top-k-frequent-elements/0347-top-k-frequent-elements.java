class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int num: nums) hm.put(num, hm.getOrDefault(num, 0)+1);

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(a[1], b[1]);
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

        for(int key: hm.keySet()){
            pq.add(new int[]{key, hm.get(key)});
            if(pq.size()>k) pq.poll();
        }

        int ans[] = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll()[0];
        }
        return ans;
    }
}