class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
        }
        if(max == 0) return 0;

        int divide=0;
        int add=0;

        while(max>1){
            if(max % 2 == 0){
                divide++;
            }
            else {
                divide++;
                add++;
            }

            max /= 2;
        }
        add++;

        int extra=0;
        

        for(int num: nums){
            if(num == 0) continue;

            while(num > 1){
                if(num%2 != 0) extra++;

                num /= 2;
            }
            extra++;
        }
        
        return divide+extra;
    }
}