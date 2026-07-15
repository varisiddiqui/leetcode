class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int prefix[] = new int[m];
        int suffix[] = new int[m];

        int i=0; // for s

        

        for(int j=0; j<m; j++){            
            if(i<n && s.charAt(i) == t.charAt(j)){
                i++;
            }

            prefix[j] = i;
        }

        if(prefix[m-1] == n) return true;

        //for(int p: prefix) System.out.println(p);
        i=n-1;

        for(int j=m-1; j>=0; j--){
            if(i>=0 && s.charAt(i) == t.charAt(j)){
                i--;
            }

            suffix[j] = n-1-i;
        }

         //for(int p: suffix) System.out.println(p);

         for(int j=0; j<m; j++){
            int left = (j>0)? prefix[j-1]: 0;
            int right = (j<m-1)? suffix[j+1]: 0;

            if(left+right >= n-1) return true;
         }

         return false;




    }
}