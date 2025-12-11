class Solution {
    public int minLengthAfterRemovals(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        int countA=0, countB=0;

        for(char ch: s.toCharArray()){
            if(ch == 'a') countA++;
            else countB++;
        }
        return Math.abs(countA-countB);
    }
}