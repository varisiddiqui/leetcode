class Solution {
    public String decodeAtIndex(String s, int k) {
        int n = s.length();

        long size=0;

        for(char ch: s.toCharArray()){
            if(ch>='a' && ch<='z') size++;
            else size *= (ch-'0');
        }

        int i=n-1;
        while(size>0){
            if(k%size==0 && !Character.isDigit(s.charAt(i))){
                return String.valueOf(s.charAt(i));
            }
            else if(k > size){
                k %= size;
            }
            else{
                if(Character.isDigit(s.charAt(i))) size /= (s.charAt(i)-'0');
                else size--;

                i--;
            }
        }
        return "a";

       
    }
}