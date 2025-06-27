class Solution {
    public long maximumProduct(int[] nums, int m) {
        int n = nums.length;
        long min=nums[0];
        long max=nums[0];
        int i=0;
        long maxP=Long.MIN_VALUE;
        for(int j=m-1; j<n; j++){
            if(j==m-1);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            long p1=min*nums[j];
            long p2=max*nums[j];

             maxP = Math.max(maxP, Math.max(p1, p2));

            i++;
        }
        return maxP;
    }
}