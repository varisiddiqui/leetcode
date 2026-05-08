class Solution {
    public int[] maxSubsequence(int[] nums, int k) {

        Comparator<int[]> cmp = (a,b) -> {
            return a[0]-b[0];
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

        for(int i=0; i<nums.length; i++){
            pq.add(new int[]{nums[i], i});
            if(pq.size()>k) pq.poll();
        }

        int ans[][] = new int[k][2];
        int j=0;

        while(!pq.isEmpty()){
            ans[j++] = pq.poll();
        }

        Comparator<int[]> cmp2 = (a, b) -> {
            return a[1]-b[1];
        };
        Arrays.sort(ans, cmp2);

        int res[] = new int[k];
        int l=0;
        for(int i=0; i<k; i++) res[l++]= ans[i][0];

        return res;
    }
}