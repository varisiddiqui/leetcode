class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        int k=-1;
        for(int i=0; i<n-1; i++){
            if(nums[i] >= nums[i+1]) k=i;
        }
        return (k==-1)?0:k+1;
    }
}