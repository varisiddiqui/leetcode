class Solution {
    public boolean parseBoolExpr(String expression) {
        int n = expression.length();
        Stack<Character> st = new Stack<>();

        
        for(int i=0; i<n; i++){
            char ch = expression.charAt(i);
            if(ch == ',') continue;

            if(ch == ')'){
                int t=0, f=0;
                while(!st.isEmpty() && st.peek() != '('){
                    if(st.peek() == 't') t++;
                    if(st.peek() == 'f') f++;
                    st.pop();
                }
                st.pop();
                boolean ans = evaluate(st.pop(), f, t);
                if(ans) st.push('t');
                else st.push('f');
            }
            else st.push(ch);
        }

        return st.peek()=='t'?true: false;
    }

    public boolean evaluate(char optr, int f, int t){
        if(optr == '|'){
            if(t == 0) return false;
            return true;
        }

        if(optr == '&'){
            if(f>0) return false;
            return true;
        }

        if(optr == '!'){
            if(t>0) return false;
            return true;
        }
        return true;
    }
}