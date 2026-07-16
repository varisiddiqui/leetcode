class Solution {

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int minOperations(int[] nums) {
        int n = nums.length;

        int one=0;

        for(int i=0; i<n; i++){ 
            if(nums[i] == 1) one++;
        }

        if(one>0) return n-one;

        int op=0;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int gcd = nums[i];
            op=0;
            for(int j=i+1; j<n; j++){
                 gcd = gcd(nums[j], gcd);
                 op++;
                 if(gcd == 1){
                     min = Math.min(op, min);
                     break;
                 }

            }
        }

        return min == Integer.MAX_VALUE? -1: min+n-1;
    }
}