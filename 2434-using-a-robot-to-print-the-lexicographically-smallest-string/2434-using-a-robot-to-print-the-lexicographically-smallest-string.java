class Solution {
    public String robotWithString(String s) {
        TreeMap<Character, Integer> hm = new TreeMap<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            hm.put(ch, i);
        }
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder("");
        int i=0;
        
        for(Character key: hm.keySet()){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek()<=key){
                while(!st.isEmpty() && st.peek()<=key){
                    ans.append(st.pop());
                }
                
            }
            
            while(i<n) {
                ch = s.charAt(i);
            if((key == ch) && (hm.get(key) == i)){
                ans.append(ch);
                i++;
                break;
            }
            else if((key == ch) && (hm.get(key)>i)){
                ans.append(ch);
                i++;
            }

            else if(!st.isEmpty() && st.peek()<=key){
                while(!st.isEmpty() && st.peek()<=key){
                    ans.append(st.pop());
                }
                
            }
            else if(hm.get(key)<i){
                break;
            }
            else{
                st.push(ch);
                i++;
            }
            

            }
            if(i==n) break;

        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.toString();
    }
}