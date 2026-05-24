class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        Comparator<int[]> cmp = (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(b[1], a[1]);
        };

        Arrays.sort(queries, cmp);

        PriorityQueue<Integer> maxQuery = new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> pastQuery = new PriorityQueue<>();

        int i=0;
        int idx=0;
        while(idx < n ){
            while(i<m && queries[i][0] == idx){
                maxQuery.add(queries[i][1]);
                i++;
            }
            

            while(!pastQuery.isEmpty() && pastQuery.peek()<idx) pastQuery.poll();

            if(!pastQuery.isEmpty()){
                nums[idx] -= pastQuery.size();
            }

            while(nums[idx] > 0 && !maxQuery.isEmpty() && maxQuery.peek() >= idx){
                pastQuery.add(maxQuery.peek());
                nums[idx] -= 1;
                maxQuery.poll();
            }
            if(nums[idx]>0) return -1;
            idx++;
        }

        return (m-i)+maxQuery.size();



    }
}