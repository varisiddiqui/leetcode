class Solution {
    public int minimumMoves(String s) {
        int n = s.length();
        
        int count=0;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == 'X'){
                count++;
                i += 2;
            }
        }
        return count;
    }
}