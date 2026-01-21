class Solution {
    public int compareVersion(String version1, String version2) {
        List<Integer> num1  = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();

        int n1 = version1.length();
        int n2 = version2.length();

        int i=0;
        StringBuilder str = new StringBuilder();
        while(i<n1){
            if((i==0 || version1.charAt(i-1) == '.') && version1.charAt(i) == '0'){
                while(i<n1 && version1.charAt(i) == '0') i++;
            }
            if(i==n1) break;

            if(version1.charAt(i) == '.'){
                if(str.length() == 0) num1.add(0);
                else{
                    num1.add(Integer.valueOf(str.toString()));
                    str.setLength(0);
                }
            }
            else str.append(version1.charAt(i));
            i++;
        }
        if(str.length() == 0) num1.add(0);
                else
                    num1.add(Integer.valueOf(str.toString()));


        int j=0;
        str.setLength(0);
        while(j<n2){
            if((j==0 || version2.charAt(j-1) == '.') && version2.charAt(j) == '0'){
                while(j<n2 && version2.charAt(j) == '0') j++;
            }
            if(j==n2) break;

            if(version2.charAt(j) == '.'){
                if(str.length() == 0) num2.add(0);
                else{
                    num2.add(Integer.valueOf(str.toString()));
                    str.setLength(0);
                }
            }
            else str.append(version2.charAt(j));
            //System.out.println(j+" "+str);
            j++;
        }
        if(str.length() == 0) num2.add(0);
                else
                    num2.add(Integer.valueOf(str.toString()));
        
        int n=Math.max(num1.size(), num2.size());
        System.out.println(num1+" "+num2);
       for(int k=0; k<n; k++){
        int ch1 = (k < num1.size())?num1.get(k): 0;
        int ch2 = (k<num2.size())?num2.get(k): 0;
        if(ch1 < ch2) return -1;
        else if(ch1>ch2) return 1;
       }
       return 0;

                   
                    
                

      
    }
}