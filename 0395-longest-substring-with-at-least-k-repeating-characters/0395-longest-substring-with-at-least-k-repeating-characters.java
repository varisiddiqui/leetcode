class Solution {
    public int longestSubstring(String s, int k) {

        int max=Integer.MIN_VALUE;
        int n = s.length();
        
        for(int i=1; i<=26; i++){
            HashMap<Character, Integer> hm = new HashMap<>();
            int l=0;
            int r=0;

            while(r<n){
                
                char right = s.charAt(r);

                hm.put(right, hm.getOrDefault(right, 0) + 1);
                while(hm.size()>i){
                    char left = s.charAt(l);
                    if(hm.get(left)-1 > 0) hm.put(left, hm.get(left)-1);
                    else hm.remove(left);
                    l++;
                }
                r++;

                boolean yes=true;
                int freq=0;

                for(Character key: hm.keySet()){
                    if(hm.get(key)<k){
                        yes = false;
                        break;
                    }
                    freq += hm.get(key);
                }
                if(yes) max = Math.max(max, freq);
            }
            //System.out.println(max);
            

        }
        return (max == Integer.MIN_VALUE)?0: max;
    }
}