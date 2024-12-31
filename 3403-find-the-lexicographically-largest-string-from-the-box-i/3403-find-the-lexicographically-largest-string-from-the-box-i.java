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
        int len = word.length();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<word.length(); i++){
            String c = word.charAt(i)+"";
            pq.add(new Pair(c, i));
        }

        if(numFriends == 1){
            return word;
        }

    
        else if(len == numFriends){
            return pq.peek().ch;
        }

        else{
        String largest ="";
        String largestCh = pq.peek().ch;

        //PriorityQueue<String> lar = new PriorityQueue<>(Collections.reverseOrder());
        String high = "";

        while((pq.peek() != null) && (pq.peek().ch).equals(largestCh)){
            int index = pq.peek().idx;
            if((index-numFriends) >= 0){
                largest = word.substring(index, len);
                high = (high.compareTo(largest)<0)? largest : high;
            }
            else{
                largest = word.substring(index, len-(numFriends-index)+1);
                high = (high.compareTo(largest)<0)? largest : high;
            }
            pq.remove();
        }

        return high;
    }

    }
}