class Solution {
    public String removeStars(String s) {
        int n = s.length();

        StringBuilder ans = new StringBuilder(s.charAt(0));
    
        

        for(char ch: s.toCharArray()){
            if(ch != '*') ans.append(ch);
            else ans.deleteCharAt(ans.length()-1);
        }

        return ans.toString();
    }
}