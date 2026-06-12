class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n = words.length;

        HashMap<String, Boolean> dp = new HashMap<>();

        List<String> ans = new ArrayList<>();
        if(n==1 || n==2) return ans;

        Set<String> set = new HashSet<>();
        for(String w: words) set.add(w);



        for(String w: words){
            if(isConcatenated(w, set, dp)){
                ans.add(w);
            }
        }
        return ans;
    }

    public boolean isConcatenated(String word, Set<String> set, HashMap<String, Boolean> dp){
        int n = word.length();

        if(dp.containsKey(word)) return dp.get(word);

        for(int i=1; i<n; i++){
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, n);

            if(set.contains(prefix) && set.contains(suffix)){
                //dp.put(suffix, true);
                return true;
            } 
            if(set.contains(prefix) && isConcatenated(suffix, set, dp)){
                dp.put(suffix, true);
                return true;
            }
        }

        dp.put(word,false);
        return false;
    }
}