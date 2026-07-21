class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        int active=0;

        int prefix[] = new int[n];
        int suffix[] = new int[n];

        int left = n;
        prefix[0] = -1;

        if (s.charAt(0) == '0') left=0;
        else active=1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                left = Math.min(left, i);
                prefix[i] = -1;
            } else {
                prefix[i] = (left != n)? left: -1;
                active++;
            }

            if (s.charAt(i) == '1' && i + 1 < n && s.charAt(i + 1) == '0')
                left = n;
        }

        int right = -1;

        suffix[n - 1] = -1;

        if(s.charAt(n-1) == '0') right = n-1;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                right = Math.max(right, i);
                suffix[i] = -1;
            }
            else{
                suffix[i] = right != -1? right: -1;
            }

            if(s.charAt(i) == '1' && i-1>=0 && s.charAt(i-1) == '0') right=-1;
        }

        

        int start=-1;
        int end = -1;
      

        //count prefix for 1

        int countL[] = new int[n];
        

        if(s.charAt(0) == '1') countL[0]=1;

        for(int i=1; i<n; i++){
            if(s.charAt(i) == '1') countL[i]++;

            countL[i] += countL[i-1];
        }

        
        int currOne = 0;
        int ans =0;
        for(int i=1; i<n-1; i++){
            if(prefix[i] != -1 && suffix[i] != -1){
                
                    
                    start = prefix[i];
                    end = suffix[i];

                    if(start == 0) currOne = countL[end];
                    else
                    currOne = countL[end]-countL[start-1];

                    ans = Math.max(ans, active-currOne+end-start+1);
                }
            } 
        

        



        
      

        if(start==-1 || end==-1) return active;

        

        

        return ans;

    }
}