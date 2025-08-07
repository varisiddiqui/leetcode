class Solution {
    public boolean parseBoolExpr(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            
            if(st.isEmpty() || ch != ')'){
                if(ch != ',')
                st.push(ch);
            }
            else{
                StringBuilder str = new StringBuilder("");

                while(!st.isEmpty() && st.peek() != '('){
                    str.append(st.pop());
                }
                st.pop();//to remove '('
                
                //case 1
                if(st.peek() == '&'){
                    st.pop();
                    boolean top = and(str.toString());
                    if(top == true)
                    st.push('t');
                    else
                    st.push('f');
                }

                //case 2    
                if(st.peek() == '|'){
                    st.pop();
                    boolean top = or(str.toString());
                    if(top == true)
                    st.push('t');
                    else
                    st.push('f');
                }

                //case 3
                if(st.peek() == '!'){
                    st.pop();
                    if(str.charAt(0) == 't')
                    st.push('f');
                    else
                    st.push('t');
                }

            }

           
        }

        return st.peek()=='t'? true: false;
    }

    public boolean and(String exp){
        boolean res=true;
        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            if(ch == 't')
            res = res && true;
            if(ch == 'f')
            res = res && false;
        }
        return res;
    }

    

    public boolean or(String exp){
        boolean res=false;
        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            if(ch == 't')
            res = res || true;
            if(ch == 'f')
            res = res || false;
        }
        return res;

    }
}