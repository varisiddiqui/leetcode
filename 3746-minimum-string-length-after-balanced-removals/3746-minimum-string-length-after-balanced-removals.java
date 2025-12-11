class Solution {
    public int minLengthAfterRemovals(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for(char ch: s.toCharArray()){
            if(st.isEmpty()) st.push(ch);

            else if(st.peek()=='a' && ch=='b') st.pop();

            else if(st.peek()=='b' && ch=='a') st.pop();

            else st.push(ch);
        }
        return st.size();
    }
}