class Solution {
    public int minimumBuckets(String h) {
        Set<Integer> set = new HashSet<>();
        int n = h.length();

        for(int i=0; i<n; i++){
            if(h.charAt(i) == 'H') set.add(i);
        }
        int ans = 0;

        for(int i=0; i<n; i++){
            char ch = h.charAt(i);
            if(ch == 'H' && set.contains(i)){
                if(i+1<n && h.charAt(i+1)=='.' && i+2<n && h.charAt(i+2)=='H'){
                    set.remove(i);
                    set.remove(i+2);
                    ans++;
                }
            }
        }

        for(int i=0; i<n; i++){
            char ch = h.charAt(i);
            if(ch == 'H' && set.contains(i)){
                if((i-1>=0 && h.charAt(i-1)=='.') || (i+1<n && h.charAt(i+1)=='.')){
                    ans++;
                    set.remove(i);
                }
            }
            
        }
        if(set.size()>0) return -1;
        return ans;
    }
}