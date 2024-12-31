import java.util.*;
class Solution {
    

 public String answerString(String word, int numFriends) {
        int len = word.length();
        //PriorityQueue<Pair> pq = new PriorityQueue<>();

        String largest = "";
        
        char larg = 'a';

        for (char ch : word.toCharArray()) {
            if (ch > larg) {
                larg = ch; 
            }
        }
        largest = larg+"";

        if(numFriends == 1){
            return word;
        }

    
        else if(len == numFriends){
            return largest;
        }

        else{
        
       // String largestCh = pq.peek().ch;

        //PriorityQueue<String> lar = new PriorityQueue<>(Collections.reverseOrder());
        String high = "";
        for(int i=0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            String l = String.valueOf(ch);

            if(l.equals(largest)){

            if((i-numFriends) >= 0){
               String  ll = word.substring(i, len);
                high = (high.compareTo(ll)<0)? ll : high;
            }
            else{
                String ll = word.substring(i, len-(numFriends-i)+1);
                high = (high.compareTo(ll)<0)? ll : high;
            }
            
        }
        }
    

        return high;
    }

    }
}