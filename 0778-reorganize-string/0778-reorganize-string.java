class Solution {

    static class Pair{
        char ch;
        int freq;
        public Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String reorganizeString(String s) {
        int freq[]= new int[26];
        int n = s.length();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }

        Comparator<Pair> cmp = (a, b) -> {
        
            return Integer.compare(b.freq, a.freq);
            
        };

        PriorityQueue<Pair> pq = new PriorityQueue<>(cmp);

        for(int i=0; i<26; i++){
            if(freq[i] > 0){
                pq.add(new Pair((char)(i+97), freq[i]));
            }
        }

        StringBuilder str = new StringBuilder("");
        while(pq.size()>=2){
            Pair t1 = pq.remove();
            Pair t2 = pq.remove();

            str.append(t1.ch);
            str.append(t2.ch);

            if(t1.freq>1){
                t1.freq--;
                pq.add(t1);
            }
            
            if(t2.freq>1){
                t2.freq--;
                pq.add(t2);
            }
            

            
        }

        if(!pq.isEmpty()){
            if(pq.peek().freq>1){
                return "";
            }
            else
            str.append(pq.peek().ch);
        }

        return str.toString();



    }
}