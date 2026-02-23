class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long a[] = new long[n];
        a[0]=1;
        int MOD = 1_000_000_007;
        long forgot=0;
        for(int i=0; i<n; i++){
            if(a[i]>0){
                for(int j=i+delay; j<n && j<i+forget; j++){
                    a[j] = (a[j] +a[i])%MOD;
                }
                if(i+forget < n)
                forgot =  (forgot + a[i]) % MOD;
            }
        }

        long sum=0;
        for(long num: a){
            sum += num;
            sum = sum % MOD;
        }
        return (int)(sum-forgot+MOD)%MOD; 
    }
}