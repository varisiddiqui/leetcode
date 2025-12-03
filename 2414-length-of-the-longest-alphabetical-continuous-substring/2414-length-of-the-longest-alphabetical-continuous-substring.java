class Solution {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        if(n==1) return 1;

        int max=0;
        int i=0;
        char curr=s.charAt(i);
        int c=1;
        for(i=1; i<n; i++){
            if((++curr) == s.charAt(i))  c++;
            else{
                max = Math.max(max, c);
                c=1;
                
            } 

            curr = s.charAt(i);                
            
        }
        max = Math.max(max, c);
        return max;

        
    }
}