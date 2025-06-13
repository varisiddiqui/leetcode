class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> l =  new ArrayList<>();
        int n = strs.length;
        String dup[] = new String[n];
        for(int i=0; i<n; i++){
            dup[i] = strs[i];
        }
        for(int i=0; i<n; i++){
            char ch[] = strs[i].toCharArray();
            Arrays.sort(ch);
            strs[i] = String.valueOf(ch);
        }
        
        HashMap<String , ArrayList<Integer>> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            hm.putIfAbsent(strs[i], new ArrayList<>());
            hm.get(strs[i]).add(i);
        }
        for(String key: hm.keySet()){
            ArrayList<Integer> al = hm.get(key);
            ArrayList<String> ans = new ArrayList<>();
            for(int i=0; i<al.size(); i++){
                ans.add(dup[al.get(i)]);
            }
            l.add(ans);
        }
        return l;
    }
}