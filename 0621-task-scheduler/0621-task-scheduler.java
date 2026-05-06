class Solution {
    static class Pair{
        char ch;
        int freq;

        public Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int l = tasks.length;
        
        Comparator<Pair> cmp = (a, b) -> {
            return b.freq-a.freq;
        };

        PriorityQueue<Pair> pq  = new PriorityQueue<>(cmp);

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<l; i++)
        hm.put(tasks[i], hm.getOrDefault(tasks[i], 0)+1);

        for(char key: hm.keySet()){
            pq.add(new Pair(key, hm.get(key)));
        }

        int k = n+1;

        int round=0;

        while(!pq.isEmpty()){
            List<Pair> li = new ArrayList<>();
            int idle=0;
            for(int i=0; i<k; i++){
                if(!pq.isEmpty()){
                    li.add(pq.poll());
                }
                else idle++;
            }

            for(Pair p: li){
                if(p.freq-1 > 0){
                    p.freq--;
                    pq.add(p);
                }
            }

            if(!pq.isEmpty()){
                round += k;
            }
            else{
                round += (k-idle);
                break;
            } 
        }
        return round;

        
    }
}