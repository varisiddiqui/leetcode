class Solution {
    public int minSwaps(String s) {
        int cl=0;
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '[') st.push(s.charAt(i));
            else{
                if(!st.isEmpty()) st.pop();
                else cl++;
            }
        }
        return (cl+1)/2;
    }
}