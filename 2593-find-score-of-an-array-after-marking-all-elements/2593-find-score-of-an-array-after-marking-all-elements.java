class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        
        Comparator<int[]> cmp = (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        };

        PriorityQueue<int[]> pq= new PriorityQueue<>(cmp);

        for(int i=0; i<n; i++){
            pq.add(new int[]{nums[i], i});
        }

        HashSet<Integer> marked = new HashSet<>();

        long score=0;

        while(!pq.isEmpty()){
            while(!pq.isEmpty() && marked.contains(pq.peek()[1])) pq.poll();

            if(pq.isEmpty()) return score;

            score += pq.peek()[0];
            int currIdx= pq.poll()[1];
            if(currIdx-1>=0) marked.add(currIdx-1);
            if(currIdx+1<n) marked.add(currIdx+1);

        }

        return score;

        
    }
}