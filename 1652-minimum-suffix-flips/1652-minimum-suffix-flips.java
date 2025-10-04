class Solution {
    public int minFlips(String s) {
        char curr='0';
        int min=0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != curr){
                min++;
                curr = s.charAt(i);
            }
        }
        return min;

       
    }
}