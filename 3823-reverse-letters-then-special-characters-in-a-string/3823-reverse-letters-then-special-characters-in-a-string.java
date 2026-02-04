class Solution {
    public String reverseByType(String s) {
        StringBuilder str = new StringBuilder();
        int n = s.length();
        int special_idx = n-1;
        int lower_idx = n-1;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int ascii = (int) ch;
           // System.out.println(ch +" "+ascii);
            if (ascii >= 97 && ascii <= 122) {
                while (lower_idx >=0 && ((int)s.charAt(lower_idx) <97 || (int)s.charAt(lower_idx)>122)) {
                    lower_idx--;
                }
                if(lower_idx >=0 && (int)s.charAt(lower_idx) >=97 && (int)s.charAt(lower_idx)<=122){
                    str.append(s.charAt(lower_idx));
                    lower_idx--;
                }
                
            }

            if (ascii < 97 || ascii > 122) {
                while (special_idx >=0 && (int)s.charAt(special_idx) >=97 && (int)s.charAt(special_idx)<=122) {
                    special_idx--;
                }
                if(special_idx >=0 && ((int)s.charAt(special_idx) <97 || (int)s.charAt(special_idx)>122)){
                    str.append(s.charAt(special_idx));
                    special_idx--;
                }
                
            }

        }

        return str.toString();
    }
}