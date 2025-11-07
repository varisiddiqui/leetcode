class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;
        int c=0;
        for(int i=0; i<n; i++) {
            if(nums[i]==0) c++;
            nums[i]=Math.abs(nums[i]);
        }
         Arrays.sort(nums);

        if(c>n-2) return 0;

        if(c==n-2) return nums[n-1]*1L*nums[n-2]*100000L;

        return nums[n-1]*1L*nums[n-2]*100000L;

       
        

        


    }
}