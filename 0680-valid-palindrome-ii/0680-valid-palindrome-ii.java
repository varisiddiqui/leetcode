class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i=0;
        int j=n-1;
        
        StringBuilder str = new StringBuilder(s);
        StringBuilder str2 = new StringBuilder(s);

        while(i<=j){
            char l = s.charAt(i);
            char r = s.charAt(j);

            if(l != r){
             String s1 = str.deleteCharAt(i).toString();
             String s2 = str2.deleteCharAt(j).toString();
             return isPal(s1) || isPal(s2);
                
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPal(String str){
        int i=0;
        int j=str.length()-1;
        while(i<=j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }


    
}