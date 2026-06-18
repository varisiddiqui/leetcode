class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int pos=0;
        int neg=0;
        int ans=0;

        for(char ch: s.toCharArray()){
            if(ch == '(') pos++;
            else neg++;

            if(neg>pos){
                ans++;
                neg=0;
                pos=0;
            }
        }

        if(pos>neg) ans+=(pos-neg);

        return  ans;
    }
}