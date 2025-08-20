class Solution {
    public String customSortString(String order, String s) {
        StringBuilder str = new StringBuilder("");

        int n = order.length();
        Set<Character> set = new HashSet<>();

        for(int i=0; i<n; i++){
            char ch = order.charAt(i);
            set.add(ch);
            for(int j=0; j<s.length(); j++){
                if(ch == s.charAt(j))
                str.append(ch);
            }
        }
        for(int i=0; i<s.length(); i++){
            if(!set.contains(s.charAt(i)))
            str.append(s.charAt(i));
        }

        return str.toString();
    }
}