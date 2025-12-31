class Solution {
    public int magicalString(int n) {
        StringBuilder str = new StringBuilder("122");

        int next = 2; //read ptr
        char ch = '1';

        while(str.length() < n){
            int count = str.charAt(next) - '0';
            for(int i=0; i<count; i++){
                str.append(ch);
            }
            next++;
            ch = (ch == '1')?'2':'1';
        }


        int c=0;

        for(int i=0; i<n; i++){
            if(str.charAt(i) == '1') c++;
        }
        return c;

        

    }
}