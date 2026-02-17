class Solution {
    public int prefixConnected(String[] words, int k) {
        int n = words.length;
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i=0; i<n; i++){
            if(words[i].length()>=k){
                String key = words[i].substring(0, k);
            hm.put(key, hm.getOrDefault(key, 0) + 1);
            }
            
        }
        int c=0;

        for(String key: hm.keySet()){
            if(hm.get(key)>1) c++;
        }
        return c;
    }
}