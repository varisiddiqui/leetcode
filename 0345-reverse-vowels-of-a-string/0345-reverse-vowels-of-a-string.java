class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder(s);

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');


        int i=0;
        int j=n-1;

        while(i<j){
            
            while(i<n && !set.contains(s.charAt(i))){
                i++;
            }

            while(j>=0 && !set.contains(s.charAt(j))){
                j--;
            }

            if(i>=j) break;

            char temp = s.charAt(i);
            str.setCharAt(i, s.charAt(j));
            str.setCharAt(j, temp);
            i++;
            j--;
        }
        return str.toString();
    }
}