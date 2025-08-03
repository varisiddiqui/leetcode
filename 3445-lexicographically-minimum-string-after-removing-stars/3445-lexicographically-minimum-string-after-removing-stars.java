class Solution {
    public String clearStars(String s) {
        TreeMap<Character, List<Integer>> tm = new TreeMap<>();
        int n = s.length();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch != '*') {
                tm.putIfAbsent(ch, new ArrayList<>());
                tm.get(ch).add(i);
            }
            else{
                char key = tm.firstKey();
                int size = tm.get(key).size();
                    set.add(tm.get(key).get(size-1));
                    tm.get(key).remove(size-1);
                    if(size-1 == 0)
                    tm.remove(key);
                }
            }
        if(set.size() == 0)
        return s;

        StringBuilder res = new StringBuilder();
        for(int i=0; i<n; i++){
            if(!set.contains(i) && s.charAt(i) != '*'){
                res.append(s.charAt(i));
            }
        }

        return res.toString();


    }
}