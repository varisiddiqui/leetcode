class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int l=0;
        int r=0;

        int maxFreq=0;

        int max=0;
        

        HashMap<Character, Integer> hm = new HashMap<>();
        

        while(r<n){
            char ch = s.charAt(r);
            hm.put(ch, hm.getOrDefault(ch,0)+1);

            maxFreq = Math.max(maxFreq, hm.get(ch));

            int limit = r-l+1 - maxFreq;
            

            while(limit > k){
                char c = s.charAt(l);
                if(hm.get(c)-1 == 0) hm.remove(c);
                else hm.put(c, hm.get(c)-1);
                maxFreq=0;

                for(char key: hm.keySet()){
                    maxFreq = Math.max(maxFreq, hm.get(key));
                }
             
                l++;

                limit = r-l+1 - maxFreq;
            }

            if(limit <= k) max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}