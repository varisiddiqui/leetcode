class Solution {
    public String longestPrefix(String s) {
        int n = s.length();

        int i=1;
        int lps[] = new int[n];

        int len=0;
        
        while(i<n){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len != 0) len = lps[len-1];
                else {
                    lps[i]=0;
                    i++;
                }
            }
        }
        System.out.println(lps[n-1]);
        return lps[n-1] == 0? "":s.substring(0, lps[n-1]);
    }
}