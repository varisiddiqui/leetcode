class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int i=0;
        int j=0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int count=0;
        
        while(i<n && j<n){
            char ch = s.charAt(j);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            while(hm.size() == 3){
                count++;
                count += (n-1)-j;
                char dlt = s.charAt(i);
                if(hm.get(dlt)-1 == 0) hm.remove(dlt);
                else hm.put(dlt, hm.get(dlt)-1);
                i++;
            }
            j++;
        }
        return count;
    }
}