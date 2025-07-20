class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            String word = words[i];
            HashMap<Character, Character> hm = new HashMap<>();
            Set<Character> set = new HashSet<>();
            boolean isMatching = true;
            for(int j=0; j<pattern.length(); j++){
                char ch = pattern.charAt(j);
                if(hm.containsKey(ch)){
                    if(hm.get(ch) != word.charAt(j)){
                        isMatching = false;
                        break;
                    }

                }
                else {
                    if(set.contains(word.charAt(j))){
                        isMatching = false;
                        break;
                    }
                    else{
                        hm.put(ch, word.charAt(j));
                        set.add(word.charAt(j));
                    }
                }
            }

            if(isMatching){
                result.add(word);
            }
            
        }
        return result;
    }
}