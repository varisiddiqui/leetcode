class Solution {
    public String removeStars(String s) {
        int n = s.length();

        Stack<Character> st = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '*'){
                 if (!st.isEmpty()) st.pop();
            }
           
            else st.push(ch);
        }

        StringBuilder ans = new StringBuilder();

        while(!st.isEmpty()) ans.insert(0, st.pop());
        return ans.toString();
    }
}