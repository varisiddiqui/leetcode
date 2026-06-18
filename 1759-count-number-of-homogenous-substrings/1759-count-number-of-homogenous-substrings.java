class Solution {
    public int countHomogenous(String s) {
        int n = s.length();
        if(n==1) return 1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int count=1;
        for(int i=1; i<n; i++){
            if(s.charAt(i-1) == s.charAt(i)) count++;
            else{
                hm.put(count, hm.getOrDefault(count, 0) + 1);
                count=1;
            }

            if(i==n-1) hm.put(count, hm.getOrDefault(count, 0) + 1);
        }

        long ans=0;

        for(int key: hm.keySet()){
            ans += ((key*1L*(key+1)/2)*hm.get(key));
           
        }

        return (int)(ans % 1_000_000_007);
    } 
}