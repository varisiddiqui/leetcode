class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;

        int pr=1;
        int suff=1;

        for(int i=0; i<n; i++){
            if(pr == 0) pr = 1;
            if(suff == 0) suff = 1;

            pr = pr * nums[i];
            suff = suff * nums[n-i-1];

            max = Math.max(max, Math.max(pr, suff));
        }
        return max;
    
    }
}