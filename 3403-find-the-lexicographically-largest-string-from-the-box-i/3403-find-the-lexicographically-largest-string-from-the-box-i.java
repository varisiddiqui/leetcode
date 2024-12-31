import java.util.*;
class Solution {
    

 public String answerString(String word, int numFriends) {
        int len = word.length();
        //PriorityQueue<Pair> pq = new PriorityQueue<>();

        String largest = "";
        for(char ch ='z'; ch >= 'a'; ch--){
            String c = String.valueOf(ch);
            if(word.contains(c)){
                largest = c;
                break;
            }
        }

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