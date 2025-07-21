class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        //in previous it was robbed till ith taking it.
        // its max robbed till ith may or may not
        int prev1 = Math.max(nums[0], nums[1]);
        int prev2 = nums[0];
        int curr =0;

        for(int i=2; i<n; i++){
         curr = Math.max(prev1, prev2+nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr; 
        
    }
}