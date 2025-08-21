class Solution {
    public boolean isNStraightHand(int[] nums, int size) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(a[0], b[0]);
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

        for (Integer key : hm.keySet()) {
            pq.add(new int[] { key, hm.get(key) });
        }
        
        int arr[][] = new int[size][2];
        

        while (pq.size() >= size) {
           for(int k=0; k<size; k++){
            arr[k]=pq.remove();
           }

           for(int i=0; i<size-1; i++){
            
            if(arr[i][0]+1 != arr[i+1][0])
            return false;
           }

           for(int i=0; i<size; i++){
            if(arr[i][1]>1)
            pq.add(new int[]{arr[i][0], --arr[i][1]});
           }
    
            }
    
           return pq.size()>0? false: true;

        }

    
}
