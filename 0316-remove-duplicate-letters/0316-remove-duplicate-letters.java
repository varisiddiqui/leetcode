class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();

        HashMap<Character, Integer> freq = new HashMap<>();

        for(char ch: s.toCharArray()) freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        Set<Character> set = new HashSet<>();

        Stack<Character> st = new Stack<>();

        for(char ch: s.toCharArray()){
            if(!set.contains(ch) ){
                while(!st.isEmpty() && st.peek()>ch && freq.get(st.peek())>0){
                    set.remove(st.pop());
                    
                }

                st.push(ch);
                set.add(ch);
                
            }
            freq.put(ch, freq.get(ch)-1);
        
        }

        StringBuilder ans = new StringBuilder();

        while(!st.isEmpty()){
            ans.insert(0, st.pop());
        }

        return ans.toString();
    }
}