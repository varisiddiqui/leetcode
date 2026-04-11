class Solution {
    public boolean isAnagram(String s, String t) {
        int freqS[] = new int[26];
        int freqT[] = new int[26];

        int n = s.length();
        if(n != t.length()) return false;

        for(int i=0; i<n; i++){
            freqS[s.charAt(i)-'a']++;
            freqT[t.charAt(i)-'a']++;
        }
        
        for(int i=0; i<26; i++){
           // System.out.println(freqS[i]+" "+freqT[i]);
            if(freqS[i] != freqT[i]) return false;
        }
        return true;
    }
}