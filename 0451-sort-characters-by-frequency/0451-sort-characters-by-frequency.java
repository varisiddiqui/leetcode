class Solution {
    static class Pair implements Comparable<Pair>{
        char ch;
        int freq;

        public Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair p2){
            return p2.freq-this.freq;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(Character key: hm.keySet()){
            pq.add(new Pair(key, hm.get(key)));
        }

        StringBuilder result = new StringBuilder("");

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int i=0; 
            while(i<p.freq){
                result.append(p.ch);
                i++;
            }
        }
        return result.toString();

        
    }
}