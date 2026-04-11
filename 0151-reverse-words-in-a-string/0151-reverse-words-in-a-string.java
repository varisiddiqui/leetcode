class Solution {
    public String reverseWords(String s) {
        List<String> li = new ArrayList<>();

        StringBuilder str = new StringBuilder();
        int n = s.length();

        for(int i=0; i<n; i++){
            if(s.charAt(i) == ' '){
                continue;
            }
            else if(i-1>=0 && s.charAt(i-1) == ' ' && s.charAt(i) != ' '){
                li.add(str.toString());
                str.setLength(0);
                str.append(s.charAt(i));
            }
            else str.append(s.charAt(i));

           // System.out.println(str);
        }
       // System.out.println(li);

        if(str.length() > 0) li.add(str.toString());

        String ans="";

        for(int i=li.size()-1; i>=0; i--){
            ans += li.get(i)+" ";
        }

        
        int j=0;
        while(j<n && ans.charAt(j) == ' ') j++;
        int l=ans.length()-1;
        while(l>=0 && ans.charAt(l) == ' ') l--;
        String res = ans.substring(j, l+1);
        return res;
    }
}