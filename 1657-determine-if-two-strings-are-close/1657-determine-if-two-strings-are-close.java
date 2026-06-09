class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        if(n1 != n2) return false;

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(char ch: word1.toCharArray()){
            freq1[ch-'a']++;
        }

        for(char ch: word2.toCharArray()){
            freq2[ch-'a']++;
        }

        HashMap<Integer, Integer> f2 = new HashMap<>();

        for(int i=0; i<26; i++){
            if((freq1[i] > 0 && freq2[i]==0) || (freq1[i]==0 && freq2[i]>0)){
                return false;
            } 

            f2.put(freq2[i], f2.getOrDefault(freq2[i], 0) + 1); 
        }

        for(int i=0; i<26; i++){
            if(freq1[i] > 0 && !f2.containsKey(freq1[i])) return false;
            else{
                if(f2.get(freq1[i])-1 > 0) f2.put(freq1[i], f2.get(freq1[i]) - 1);
                else f2.remove(freq1[i]);
            }
        }

        return f2.isEmpty();


    }
}