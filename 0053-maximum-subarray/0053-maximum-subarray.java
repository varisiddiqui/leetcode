class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum=nums[0];
        int n = nums.length;
        if(n == 1) return nums[0];

        for(int i=1; i<n; i++){
            sum += nums[i];
            if(sum<nums[i]){
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
        

    }
}