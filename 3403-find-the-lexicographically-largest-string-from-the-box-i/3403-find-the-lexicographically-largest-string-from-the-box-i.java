import java.util.*;
class Solution {
    static class Pair implements Comparable<Pair>{
        String ch;
        int idx;

        public Pair(String ch, int idx){
            this.ch = ch;
            this.idx = idx;
        }

        public int compareTo(Pair p2){
            /* return (p2.ch).compareTo(this.ch); */
            if((this.ch).equals(p2.ch)){
                return this.idx-p2.idx;
            }
            else{
                return (p2.ch).compareTo(this.ch);
            }
        }
    }

   public String answerString(String word, int numFriends) {
         PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<word.length(); i++){
            String c = word.charAt(i)+"";
            pq.add(new Pair(c, i));
        }

        int len = word.length();
        String largest ="";
        String largestCh = pq.peek().ch;

        PriorityQueue<String> lar = new PriorityQueue<>(Collections.reverseOrder());

        while((pq.peek() != null) && (pq.peek().ch).equals(largestCh)){
            int index = pq.peek().idx;
            if((index-numFriends) >= 0){
                largest = word.substring(index, len);
                lar.add(largest);
            }
            else{
                largest = word.substring(index, len-(numFriends-index)+1);
                lar.add(largest);
            }
            pq.remove();
        }

        return lar.peek();

    }
}