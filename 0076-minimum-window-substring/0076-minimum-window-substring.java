class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int l=0, r=0;
        int minLength=Integer.MAX_VALUE;
        int count=0;
        int n2 = t.length();

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<n2; i++) {
            char ch = t.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
    
        int start=0;
    
        
        while(r<n){
            char ch = s.charAt(r);
            if(hm.getOrDefault(ch,0) > 0) count++;
            hm.put(ch, hm.getOrDefault(ch, 0)-1);


            while(count == n2 && l<=r){
                if(count == n2 && (r-l+1) < minLength){
                start=l;
                minLength = r-l+1;
                System.out.println(start+" "+minLength);
                }

                char c = s.charAt(l);
                
                hm.put(c, hm.getOrDefault(c,0)+1);

                if(hm.get(c)>0) count--;

                l++;
            }
            r++;

        }
        if(minLength == Integer.MAX_VALUE) return "";
        return s.substring(start, start+minLength);
    }
}