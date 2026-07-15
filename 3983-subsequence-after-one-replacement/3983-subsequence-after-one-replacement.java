class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int prefix[] = new int[m];
        int suffix[] = new int[m];

        int i=0; // for s

        

        for(int j=0; j<m; j++){
            if(j==0){
                if(s.charAt(0) == t.charAt(0)){
                    prefix[0]++;
                    i++;
                } 
                continue;
            }
            
            if(i<n && s.charAt(i) == t.charAt(j)){
                prefix[j]++;
                i++;
            }

            prefix[j] += prefix[j-1];
        }

        //for(int p: prefix) System.out.println(p);
        i=n-1;

        for(int j=m-1; j>=0; j--){
            if(j == m-1){
                if(s.charAt(i) == t.charAt(j)){
                    suffix[j]++;
                    i--;
                }

                continue;
            }

            if(i>=0 && s.charAt(i) == t.charAt(j)){
                suffix[j]++;
                i--;
            }

            suffix[j] += suffix[j+1];
        }

         //for(int p: suffix) System.out.println(p);

         for(int j=0; j<m; j++){
            int left = (j>0)? prefix[j-1]: 0;
            int right = (j<m-1)? suffix[j+1]: 0;

            if(left+1+right == n) return true;
         }

         return false;




    }
}