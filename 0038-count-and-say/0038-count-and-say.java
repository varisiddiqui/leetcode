class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        if(n==2) return "11";
        StringBuilder str = new StringBuilder("11");

        for(int i=2; i<n; i++){
            int cnt=1;
            StringBuilder newS = new StringBuilder();
            for(int j=0; j<str.length()-1; j++){
                if(str.charAt(j) == str.charAt(j+1)) cnt++;
                else{
                    newS.append((char)(cnt+'0'));
                    newS.append(str.charAt(j));
                    cnt=1;
                }
            }
            newS.append((char)(cnt+'0'));
            newS.append(str.charAt(str.length()-1));

            str = new StringBuilder(newS);
            newS.setLength(0);

        }

        return str.toString();


    }
}