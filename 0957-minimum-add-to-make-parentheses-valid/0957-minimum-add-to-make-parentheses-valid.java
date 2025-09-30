class Solution {
    public int minAddToMakeValid(String s) {
        int op = 0;
        int ans =0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                op++;
            }
            else{
                op--;
            }

            if(op<0){
                op++;
                ans++;
            }
        }

        ans += op;
        return ans;
    }
}