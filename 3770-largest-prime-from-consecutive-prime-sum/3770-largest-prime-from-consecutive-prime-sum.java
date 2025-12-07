class Solution {
    public int largestPrime(int n) {
        if(n==1) return 0;
        if(n==2) return 2;
        int prime[] = new int[n+1];
        Arrays.fill(prime, 1);
        prime[0] = prime[1] = 0;//1 and 0 are not prime

        for(int i=2; i<=Math.sqrt(n); i++){
            if(prime[i] == 1){
                for(int j=i*i; j<=n; j=j+i){
                    prime[j]=0;
                }
            }
        }

        int sum=0;
        int last=0;
        for(int i=2; i<=n; i++){
            if(prime[i] == 1){
                if(sum+i > n){
                    break;
                }
                
                sum += i;
                last = i;
            } 
        }
        if(prime[sum] == 1) return sum;
        int j=sum;

        while(prime[sum] == 0){
            if(prime[last]==1){
                sum -= last;
            }
            last--;
        }

        return sum;
    }
}