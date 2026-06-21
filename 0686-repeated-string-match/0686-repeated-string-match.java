class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        StringBuilder txt = new StringBuilder(a);

        int cnt = (int)Math.ceil((double)b.length()/(double)a.length());

        int i=0;
        while(i++<cnt-1){
            txt.append(a);
        }

        if(match(txt.toString(), b)) return cnt;

        txt.append(a);

        if(match(txt.toString(), b)) return cnt+1;
        
        return -1;
    }

    public boolean match(String txt, String pat){
        int lps[] = LPS(pat);
        int n = txt.length();
        int m = pat.length();
        
        int i=0;//for txt
        int j=0;//for pat
        
        while(i<n){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            
            if(j == m){
                return true;
            }
            else if(i<n && txt.charAt(i) != pat.charAt(j)){
                if(j != 0){
                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return false;
         
    
    }
    
    public int[] LPS(String pat){
        int n = pat.length();
        int lps[] = new int[n];
        
        int len=0;
        int i=1;
        while(i<n){
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
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}