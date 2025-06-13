class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> l =  new ArrayList<>();
        int n = strs.length;
        HashMap<String , ArrayList<Integer>> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            char ch[] = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(i);
        }
        
        
       
        for(String key: hm.keySet()){
            ArrayList<Integer> al = hm.get(key);
            ArrayList<String> ans = new ArrayList<>();
            for(int i=0; i<al.size(); i++){
                ans.add(strs[al.get(i)]);
            }
            l.add(ans);
        }
        return l;
    }
}