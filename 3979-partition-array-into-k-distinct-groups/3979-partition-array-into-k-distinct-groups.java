class Solution {
    public boolean partitionArray(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n=nums.length;

        for(int i=0; i<n; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        Comparator<int[]> cmp = (a, b) -> {
            return b[1]-a[1];
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

        for(Integer key: hm.keySet()){
            pq.add(new int[]{key, hm.get(key)});
        }

        int a[][] = new int[k][2];
        while(!pq.isEmpty() && pq.size()>=k){
            for(int i=0; i<k; i++){
                a[i][0] = pq.peek()[0];
                a[i][1] = pq.peek()[1];
                pq.remove();
            }

            for(int i=0; i<k; i++){
                if(a[i][1]-1 >0)
                pq.add(new int[]{a[i][0], a[i][1]-1});
            }
        }

        return pq.size()==0? true: false;


    }
}