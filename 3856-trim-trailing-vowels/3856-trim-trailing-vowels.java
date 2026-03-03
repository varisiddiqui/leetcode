class Solution {
    public String trimTrailingVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int n = str.length();
        System.out.println(n);
        while(n>0){
            char ch = str.charAt(n-1);
            if(set.contains(ch)){
                str.deleteCharAt(n-1);
                n--;
            }
            else break;
        }
        return str.toString();
    }
}