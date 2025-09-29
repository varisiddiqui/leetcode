class Solution {
    static class Pair{
        int idx1;
        int idx2;
        int sum;
        public Pair(int n1, int n2, int sum){
            this.idx1 = n1;
            this.idx2 = n2;
            this.sum = sum;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;

        List<List<Integer>> ans = new ArrayList<>();

        Comparator<Pair> cmp = (a, b) -> {
            return a.sum-b.sum;
        };

        PriorityQueue<Pair> pq = new PriorityQueue<>(cmp);
        Set<String> set = new HashSet<>();

        pq.add(new Pair(0, 0, nums1[0]+nums2[0]));

        while(!pq.isEmpty() && ans.size()<k){
            Pair curr = pq.remove();
            
            ans.add(new ArrayList<>(Arrays.asList(nums1[curr.idx1], nums2[curr.idx2])));

            
                if(curr.idx1+1<n1 && set.add((curr.idx1+1)+","+curr.idx2))
                pq.add(new Pair(curr.idx1+1, curr.idx2, nums1[curr.idx1+1]+nums2[curr.idx2]));
            
            
                if(curr.idx2+1<n2 && set.add(curr.idx1+","+(curr.idx2+1)))
                pq.add(new Pair(curr.idx1, curr.idx2+1, nums1[curr.idx1]+nums2[curr.idx2+1]));
            

        }



        

       

        return ans;

    }
}