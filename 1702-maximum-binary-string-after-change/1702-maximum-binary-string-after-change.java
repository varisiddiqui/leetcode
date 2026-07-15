class Solution {
    public String maximumBinaryString(String binary) {
        int n = binary.length();

        int zero=0;

        char str[] = binary.toCharArray();
        for(char ch: str){
            if(ch == '0') zero++;
        }

        int one = n-zero;

        if(zero <= 1) return binary;

        int st = binary.indexOf('0');
        

        for(int i=0; i<st; i++){
            str[i] = '1';
        }

        for(int i=st; i<=st+zero-2; i++){
            str[i] = '1';
        }

        str[st+zero-1]='0';

        for(int i=st+zero; i<n; i++) str[i] = '1';


        return String.valueOf(str);

        







    




    }
}