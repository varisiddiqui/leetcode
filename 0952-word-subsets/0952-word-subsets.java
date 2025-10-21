class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n1 = words1.length;
        int n2 = words2.length;

        List<String> res = new ArrayList<>();

        //Containing freq for words2
        HashMap<Character, Integer> freq2 = new HashMap<>();

        for(int i=0; i<n2; i++){
            HashMap<Character, Integer> hm = new HashMap<>();
            for(int j=0; j<words2[i].length(); j++){
                char ch = words2[i].charAt(j);
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            }

            for(Character key: hm.keySet()){
                freq2.put(key, Math.max(freq2.getOrDefault(key, 0), hm.get(key)));
            }
        }

        for(int i=0; i<n1; i++){
            HashMap<Character, Integer> freq1 = new HashMap<>();

            boolean isGood = true;

            for(int j=0; j<words1[i].length(); j++){
                char ch = words1[i].charAt(j);
                freq1.put(ch, freq1.getOrDefault(ch, 0) + 1);
            }

            //compare

           
                for(Character key: freq2.keySet()){
                    if(freq2.get(key) > freq1.getOrDefault(key, 0)){
                        isGood = false;
                        break;
                    }
                }
        
            

            if(isGood) res.add(words1[i]);

        }
        return res;
        
    }
}