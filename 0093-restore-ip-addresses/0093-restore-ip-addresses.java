class Solution {
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
         List<String> ans = new ArrayList<>();

        if(n>12) return ans;

        String part1 = "";
        String part2 = "";
        String part3 = "";
        String part4 = "";

        //int minL = Math.min(12, n);

       

        for(int i=0; i<3&& i<n; i++){
            

            part1 = s.substring(0, i+1);
            //check validity
            if(part1.length() > 1 && part1.charAt(0) == '0'){
                continue;
            }

            int n1 = Integer.valueOf(part1);
            if(n1<0 || n1 > 255){
                continue;
            }

            for(int j=i+1; j<i+1+3 && j<n; j++){

                part2 = s.substring(i+1, j+1);

                if(part2.length()>1 && part2.charAt(0) == '0') continue;

                int n2 = Integer.valueOf(part2);
                if(n2<0 || n2 > 255){
                    continue;
                }   

                for(int k=j+1; k<j+1+3 && k<n; k++){
                    part3 = s.substring(j+1, k+1);

                    if(part3.length() > 1 && part3.charAt(0) == '0') continue;

                    int n3 = Integer.valueOf(part3);

                    if(n3<0 || n3>255) continue;

                    for(int l=k+1; l<k+1+3 && l<n; l++){
                        part4 = s.substring(k+1, l+1);

                        if(part4.length()>1 && part4.charAt(0) == '0') continue;

                        int n4 = Integer.valueOf(part4);

                        if(n4<0 || n4>255) continue;

                        int len = part1.length()+part2.length()+part3.length()+part4.length();

                         if(len != n) continue;

                         ans.add(part1+"."+part2+"."+part3+"."+part4);

                    }
                }

                
            }

            
            
        }

        return ans;
    }
}