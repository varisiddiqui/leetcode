class Solution {
    public int sumOfPrimesInRange(int n) {
        int rev=0;
        int dup = n;
        while(dup>0){
            int d = dup%10;
            rev = rev*10+d;
            dup /= 10;
        }

        int sum=0;

        for(int i=Math.min(rev, n); i<=Math.max(rev, n); i++){
            if(i==1) continue;
            boolean isPrime=true;
            for(int j=2; j<=Math.sqrt(i); j++){
                if(i%j ==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) sum += i;
        }
        return sum;
    }
}