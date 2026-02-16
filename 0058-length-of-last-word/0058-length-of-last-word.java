class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder();
        boolean isValid = false;
        for(int i=n-1; i>=0; i--){
            if(isValid && s.charAt(i) == ' ') break;
            
            else if(s.charAt(i) != ' ') {
                isValid = true;
                str.append(s.charAt(i));
            }
        }
        return str.toString().trim().length();

    }
}