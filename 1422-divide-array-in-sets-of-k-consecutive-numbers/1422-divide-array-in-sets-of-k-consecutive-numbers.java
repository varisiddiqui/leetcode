class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {

        Comparator<int[]> cmp = (a, b) -> {
            return a[0]-b[0];
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        } 

        for(Integer key: hm.keySet()) {
            pq.add(new int[]{key, hm.get(key)});
        }

        int a[][] = new int[k][2];
        while(pq.size() >= k) {
            for(int i=0; i<k; i++){
                a[i][0]=pq.peek()[0];
                a[i][1]=pq.peek()[1];
                pq.remove();
            }

            for(int i=0; i<k-1; i++){
                if(a[i][0]+1 != a[i+1][0] )
                return false;
            }

            for(int i=0; i<k; i++){
                if(a[i][1] > 1){
                    pq.add(new int[]{a[i][0], a[i][1]-1});
                }
            }
        }

        if(pq.size()>0){
            return false;
        }
        return true;
    }
}