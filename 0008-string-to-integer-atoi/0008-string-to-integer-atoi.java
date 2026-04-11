class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        StringBuilder ans = new StringBuilder();
        
        while(i<n && s.charAt(i) == ' ') i++;
        if(i == n) return 0;

        int sign=1;

        if(s.charAt(i) == '-') {
            sign=-1;
            i++;
        }
        else if(s.charAt(i) == '+') i++;
        long num=0;
       
        while(i<n){
            int ch = s.charAt(i);
            if(ch>=48 && ch<=57){
                num = (num*10L)+(s.charAt(i)-'0');
                if(sign*num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if(sign*num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                
            }
            else break;
            i++;
        }
       return sign*(int)num;
        
    }
}