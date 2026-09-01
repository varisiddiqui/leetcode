class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        
        Stack<Character> st = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = num.charAt(i);

            while(!st.isEmpty() && st.peek() > ch && k > 0){
                st.pop();
                k--;
            }
            st.push(ch);
        }

        StringBuilder smallest = new StringBuilder();

        while(k-- > 0) st.pop(); 

        while(!st.isEmpty()){
            smallest.append(st.pop());
        }
       
        while(smallest.length()>0 && smallest.charAt(smallest.length()-1) == '0') {
            smallest.deleteCharAt(smallest.length()-1);
        }
        String ans = smallest.reverse().toString();

        

        return (ans.length() == 0)? "0": ans;
    }
}