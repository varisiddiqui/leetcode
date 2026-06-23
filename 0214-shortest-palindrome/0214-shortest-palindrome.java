class Solution {
    public String shortestPalindrome(String s) {
       
        StringBuilder str = new StringBuilder(s);//txt
   
        
        StringBuilder rev = new StringBuilder(s);//pat
        rev.reverse();
        
        String org_rev = s+"#"+rev.toString();

        int lps[] = lps(org_rev.toString());

        int pal_len = lps[org_rev.length()-1];

        StringBuilder addOn = new StringBuilder(s.substring(pal_len));

        return addOn.reverse()+s;
        
    }

    public int[] lps(String pat){
        int lps[] = new int[pat.length()];

        int i=1;
        int len=0;

        while(i<pat.length()){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len != 0){
                    len = lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }

        return lps;
    }
}