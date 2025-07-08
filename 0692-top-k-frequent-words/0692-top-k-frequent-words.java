class Solution {
    static class Pair implements Comparable<Pair>{
        String word;
        int freq;

        public Pair(String word, int freq){
            this.word = word;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair p2){
            if(this.freq == p2.freq){
                return this.word.compareTo(p2.word);
            }
            else
            return p2.freq-this.freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        int n = words.length;
        for(int i=0; i<n; i++){
            hm.put(words[i], hm.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(String key: hm.keySet()){
            pq.add(new Pair(key, hm.get(key)));
        }

        List<String> res = new ArrayList<>();

        while(!pq.isEmpty() && k>0){
            res.add(pq.remove().word);
            k--;
        }
        return res;



    }
}