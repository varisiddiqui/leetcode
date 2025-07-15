class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder("");
        int n=s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch>=97 && ch<=122){
                result.append(ch);
                //System.out.println(result);
            }
            else if(ch == '*' && result.length()>0){
                result.deleteCharAt(result.length()-1);
                //System.out.println(result);
            }
            else if(ch == '#'){
                result.append(result);
                //System.out.println(result);
            }
            else if(ch == '%'){
                result = new StringBuilder(result.reverse());
                //System.out.println(result);
            }
        }
        return result.toString();



    }
}