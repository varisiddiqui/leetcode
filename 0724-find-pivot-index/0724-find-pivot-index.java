class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum=0;
        int rightSum=0;

        int n = nums.length;
        for(int i=0; i<n; i++) rightSum += nums[i];
        

        for(int i=0; i<n; i++){
            if(leftSum == (rightSum-nums[i])){
                return i;
            }
            else{
                rightSum -= nums[i];
                leftSum += nums[i];
            }
        }
        return -1;

    }
}