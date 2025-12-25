class Solution {
    public int integerBreak(int n) {
        int i=1;
        int max = 0;
       // if(n==2) return 1;
       int div=1;

        while(i<100){
            if(i >1)
            div = (n+1)/i; // 10/2=5
            else div = (n/i);
            if(div <= 1) {
                i++;
                continue;
            }
            int res = (int)Math.pow(i, div-1) * (n- (i*(div-1)));
            if(res < max) break;
            max = res;
            i++;
            
        }
        return max;

    }
}