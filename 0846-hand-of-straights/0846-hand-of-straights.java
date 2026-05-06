class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int num: hand){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(a[0], b[0]);
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

        for(Integer key: hm.keySet()){
            pq.add(new int[]{key, hm.get(key)});
        }

        while(!pq.isEmpty()){
            List<int[]> li = new ArrayList<>();

            for(int i=0; i<groupSize; i++){
                if(pq.isEmpty()) return false;

                li.add(pq.poll());
                if(li.size()>1){
                    if(li.get(li.size()-2)[0] != li.get(li.size()-1)[0]-1) return false;
                }
            }

            for(int[] it: li){
                if(it[1]-1 > 0){
                    it[1]--;
                    pq.add(it);
                }
            }
        }
        return true;






    }
}