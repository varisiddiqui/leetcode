class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for(char ch: s.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        int total=0;
        int odd=0;

        for(char key: hm.keySet()){
            if(odd==0 && hm.get(key) % 2 != 0){
                total += hm.get(key);
                odd=1;
            }
            else{
                if(hm.get(key) % 2 != 0){
                    total += hm.get(key)-1;
                }
                else total += hm.get(key);
            }
        }
        return total;
        
    }
}