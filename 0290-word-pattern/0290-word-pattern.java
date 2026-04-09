class Solution {
    public boolean wordPattern(String pattern, String s) {
        String str[] = s.split(" ");

        int n = pattern.length();

        if(n != str.length) return false;

        HashMap<Character, String> hm = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i=0; i<n; i++){
            char ch = pattern.charAt(i);
            if(hm.containsKey(ch)){
                if(hm.get(ch).equals(str[i])){
                    continue;
                }
                else return false;
            }
            else {
                hm.put(ch, str[i]);
                set.add(str[i]);
            }
        }

        if(hm.size() != set.size()) return false;



        return true;



    }
}