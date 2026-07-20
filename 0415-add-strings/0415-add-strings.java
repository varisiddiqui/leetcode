class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        int i=n-1;;
        int j=m-1;

        int carry=0;
        StringBuilder sum = new StringBuilder();

        while(i>=0 || j>=0){
            int left = (i>=0)?num1.charAt(i)-'0': 0;
            int right = (j>=0)?num2.charAt(j)-'0': 0;

            int add = (left+right+carry)%10;

            sum.insert(0, String.valueOf(add));

            carry = (left+right+carry)/10;
            i--;
            j--;
            
        }

        if(carry>0) sum.insert(0, String.valueOf(carry));

        

       
        return sum.toString();
    }
}