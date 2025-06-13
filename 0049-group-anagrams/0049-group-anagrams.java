class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> l =  new ArrayList<>();
        int n = strs.length;
        HashMap<String , ArrayList<String>> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            char ch[] = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(strs[i]);
        }
        
        
       
        for(String key: hm.keySet()){
            l.add(hm.get(key));
        }
        return l;
    }
}