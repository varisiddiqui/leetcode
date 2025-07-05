class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hm = new HashMap<>();
        int n = t.length();
        for(int i=0; i<n; i++){
            char ch = t.charAt(i);
            hm.putIfAbsent(ch, s.charAt(i));
            if(hm.containsKey(ch)){
                if(hm.get(ch) != s.charAt(i))
                return false;
            }
        }
        HashMap<Character, Integer> freq = new HashMap<>();
        for(Character key: hm.keySet()){
            char ch = hm.get(key);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            if(freq.get(ch) >1) return false;
        }
        return true;



    }
}