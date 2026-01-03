class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int st: stones) pq.add(st);

        while(pq.size()>=2){
            int y = pq.remove();
            int x = pq.remove();

            if(x == y) continue;
            else pq.add(y-x);
        }
        if(pq.size() == 0) return 0;
        else return pq.remove();
    }
}