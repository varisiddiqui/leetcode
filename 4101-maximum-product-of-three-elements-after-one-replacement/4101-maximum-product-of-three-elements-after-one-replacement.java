class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;
        int c=0;
        long max=Long.MIN_VALUE;
        long secondMax=Long.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(nums[i]==0) c++;

            if(Math.abs(nums[i])>= max){
                secondMax = max;
                max = Math.abs(nums[i]);
            }
            else if(Math.abs(nums[i])<max && Math.abs(nums[i])>secondMax){
                secondMax=Math.abs(nums[i]);
            }
            
        }
         //Arrays.sort(nums);

        if(c>n-2) return 0;

        

        return max*1L*secondMax*100000L;

       
        

        


    }
}