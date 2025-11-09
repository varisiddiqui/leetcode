class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        if(n==3) return 1;
        if(n==4) return 2;

        boolean isPrime[] = new boolean[n];

        Arrays.fill(isPrime, true);

        isPrime[0]=isPrime[1]=false;
        for(int i=4; i<n; i=i+2) isPrime[i]=false;

    

        for(int i=3; i*i<n; i=i+2){
            if(isPrime[i]){
                for(int j=i*i; j<n; j += 2*i){
                    isPrime[j]=false;
                }
            }
        }

        int c=0;
        for(int i=0; i<n; i++){
            if(isPrime[i]) c++;
        
        }
        return c;

      

        
    }
}