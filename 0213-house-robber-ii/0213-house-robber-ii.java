class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        if(n == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        //case-1
        
        
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        int curr=0;

        for(int i=3; i<n; i++){
            curr = Math.max(prev1, prev2+nums[i-1]);
            prev2 = prev1;
            prev1 = curr;
        }
        int ans1=curr;

        //case-2
         curr=0;
         prev2=nums[1];
         prev1 = Math.max(nums[1], nums[2]);
        for(int i=3; i<n; i++){
            curr = Math.max(prev1, prev2+nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.max(ans1, curr);
    }
}