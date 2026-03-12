class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> nearest = new HashMap<>();
        int n = s.length();

        int max=0;
        int j=0;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            
            if(nearest.containsKey(ch)){
                j= Math.max(nearest.get(ch)+1, j);
                max = Math.max(max, i-j+1);
            }
            else {
                max= Math.max(max, i-j+1);
            }
            nearest.put(ch, i);


        }
        return max;


    }
}