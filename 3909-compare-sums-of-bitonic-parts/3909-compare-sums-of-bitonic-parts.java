class Solution {
    public int compareBitonicSums(int[] nums) {
        int n = nums.length;

        long leftSum=0;
        long rightSum=0;

        int l=0;

        while(l<n-1 && nums[l]<nums[l+1]) leftSum += nums[l++];

        int r=n-1;
        while(r-1>=0 && nums[r-1]>nums[r]) rightSum += nums[r--];

        if(leftSum == rightSum) return -1;

        if(leftSum < rightSum) return 1;

        return 0;




    }
}