class Solution {
    public int reverse(int x) {
        boolean neg=false;
        if(x<0){
            neg=true;
            x *= (-1);
        }
        
        long dup = x;
        long rev=0;
        while(dup>0){
            long d = dup%10;
            rev = rev*10+d;
            dup /= 10;
        }
        if(rev<(-Math.pow(2,31)) || rev>(Math.pow(2,31)-1)){
            return 0;
        }
        if(neg)
        return -(int)rev;
        return (int)rev;
        


    }
}