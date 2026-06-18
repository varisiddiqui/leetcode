class Solution {
    public int countHomogenous(String s) {
        int n = s.length();
        if(n==1) return 1;
       
        
        int count=1;
        long ans=1;
    
        for(int i=1; i<n; i++){
            if(s.charAt(i-1) == s.charAt(i)) count++;
            else{
                count=1;
            }

            ans += count;

            
        }

      

        
        return (int)(ans % 1_000_000_007);
    } 
}