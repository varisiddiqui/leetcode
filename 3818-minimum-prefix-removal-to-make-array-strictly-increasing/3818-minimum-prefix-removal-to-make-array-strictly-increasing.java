class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        int k=-1;
        for(int i=n-2; i>=0; i--){
            if(nums[i] >= nums[i+1]){
                k=i;
                break;
            }
        }
        return (k==-1)?0:k+1;
    }
}