class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        int cnt1=0;
        int cnt2=0;

        int i=n1-1;
        int j=n2-1;

        while(i>=0 || j>=0){
            while(i>=0){
                if(s.charAt(i) == '#') {
                    cnt1++;
                    i--;
                }
                else if(cnt1>0){
                    cnt1--;
                    i--;
                }
                else break;
            }

            while(j>=0){
                if(t.charAt(j) == '#'){
                    cnt2++;
                    j--;
                }
                else if(cnt2>0){
                    j--;
                    cnt2--;
                }
                else break;
            }

            char f = i>=0?s.charAt(i):'@';
            char ss = j>=0?t.charAt(j):'@';

            if(f != ss) return false;

            i--;
            j--;


           
            
        }
          

        
        return true;
    }
}