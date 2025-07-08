class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n<3) return false;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
       

        int prevSmall[] = new int[n];
        int nextGreater[] = new int[n];

        for(int i=0; i<n; i++){
            min = Math.min(min, nums[i]);
            prevSmall[i] = min;
        }

        for(int i=n-1; i>=0; i--){
            max = Math.max(max, nums[i]);
            nextGreater[i] = max;
        }

        for(int i=1; i<n-1; i++){
            if(prevSmall[i-1]<nums[i] && nums[i]<nextGreater[i+1])
            return true;
        }
        return false;


       
       
    }
}