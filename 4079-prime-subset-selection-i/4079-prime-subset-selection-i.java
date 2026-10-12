class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        

        List<Integer> prime = new ArrayList<>();
        if(n==1) return prime;
        

        int sum=2;
       
        if(sum > s) return prime;
        prime.add(2);

        for(int i=3; i<=n; i=i+2){
            if(isPrime(i)){
                sum += i;

                if(sum > s){
                    sum -= i;
                    break;
                }

                prime.add(i);
            }
        }

        System.out.print(prime);

        return prime;
    }

    public boolean isPrime(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }

        return true;
    }
}