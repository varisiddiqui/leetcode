class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int prefix=1;
        int suffix=1;

        int ans = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            
            prefix = ((prefix == 0)? 1: prefix)* nums[i];
            suffix = ((suffix == 0)? 1: suffix) * nums[n-1-i];

            ans = Math.max(ans, Math.max(prefix, suffix));
        }

        return ans;
    }
}