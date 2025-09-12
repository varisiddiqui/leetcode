class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sum_odd=0, c1=0;
        int sum_even=0, c2=0;

        for(int i=2; i<=2000 && c1<n; i++){
            if(i%2==0 ){
                c1++;
                sum_even += i;
            }
            
            
        }

        for(int i=1; i<=2000 && c2<n; i++){
            
            if(i%2 != 0){
                c2++;
                sum_odd += i;
            }
           
        }

         while (sum_even != 0) {
            int temp = sum_even;
            sum_even = sum_odd % sum_even; 
            sum_odd = temp;
        }
        return sum_odd;
    }
}