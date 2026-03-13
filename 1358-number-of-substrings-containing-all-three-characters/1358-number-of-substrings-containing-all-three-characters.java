class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int l=0,r=0;
        HashMap<Character, Integer> hm = new HashMap<>();

        int sum=0;

        while(r<n){
            char ch = s.charAt(r);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);

            while(hm.size() == 3){
                sum += (n-r);
                char c = s.charAt(l);
                
                if(hm.get(c)-1 == 0) hm.remove(c);
                else hm.put(c, hm.getOrDefault(c, 0)-1);

                
                l++;

                
            }
            
            r++;

        }

        return sum;

    }
}