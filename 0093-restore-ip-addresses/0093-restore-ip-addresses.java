class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();

        if(s.length() > 12) return ans;
        findIp(s, "", 0, 0, s.length(), ans);

        return ans;
    }

    public void findIp(String s, String str, int stIdx, int parts, int n,
    List<String> ans){
        if(parts>4) return;

        if(parts == 4 && stIdx==n){
            ans.add(str.substring(0, str.length()-1));
            return;
        }

        if(stIdx<n){
            String part1 = s.substring(stIdx, stIdx+1); // this is the part
            int num1 = Integer.valueOf(part1);

            if((part1.length()>1 && part1.charAt(0) != '0' && (num1>=0 && num1<=255)) || (part1.length() == 1)){
                
                findIp(s, str+part1+".", stIdx+1, parts+1, n, ans);
            }
        }
        

        if(stIdx+1<n){
            String part2 = s.substring(stIdx, stIdx+2); // this is the part
            int num2 = Integer.valueOf(part2);

            if((part2.length()>1 && part2.charAt(0) != '0'  && (num2>=0 && num2<=255)) ||  (part2.length() == 1)){
                
                findIp(s, str+part2+".", stIdx+2, parts+1, n, ans);
            }
        }
        

        if(stIdx+2<n){
            String part3 = s.substring(stIdx, stIdx+3); // this is the part
            int num3 = Integer.valueOf(part3);

            if((part3.length()>1 && part3.charAt(0) != '0'  && (num3>=0 && num3<=255) ) || (part3.length() == 1)){
                
                findIp(s, str+part3+".", stIdx+3, parts+1, n, ans);
            }
        }
        
        

    }
}