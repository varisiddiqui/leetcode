class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();

        int zero=0;
        int one=0;

        for(char ch: s.toCharArray()){
            if(ch == '0') zero++;
            else one++;
        }

        int ans = Integer.MAX_VALUE;

        

        int leftZero=0;
        int leftOne=0;

        for(int i=0; i<n; i++){
            
            if(s.charAt(i) == '0') leftZero++;

            if(s.charAt(i) == '1'){
                int req = leftOne;
                req += zero-leftZero;
                ans = Math.min(ans, req);
            }
            else{
                int req = leftOne;
                req += zero-leftZero;
                ans = Math.min(ans, req);
            }

            if(s.charAt(i) == '1') leftOne++;
            
        }

        return ans;

       
    }
}