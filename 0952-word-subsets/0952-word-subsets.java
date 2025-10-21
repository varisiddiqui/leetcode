import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq2 = new int[26];  // stores max freq needed for each char
        
        // Build global max freq from words2
        for (String word : words2) {
            int[] temp = new int[26];
            for (char c : word.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                freq2[i] = Math.max(freq2[i], temp[i]);
            }
        }

        List<String> res = new ArrayList<>();

        
        for (String word : words1) {
            int[] freq1 = new int[26];
            for (char c : word.toCharArray()) {
                freq1[c - 'a']++;
            }

            boolean isGood = true;
            for (int i = 0; i < 26; i++) {
                if (freq1[i] < freq2[i]) {
                    isGood = false;
                    break;
                }
            }

            if (isGood) res.add(word);
        }

        return res;
    }
}
