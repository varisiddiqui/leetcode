class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        return count(nums, minK, maxK);
    }

    public long count(int nums[], int min, int max){
        long cnt=0;

        int len = 0;       

        for(int i=0; i<nums.length; i++){
            if(nums[i] >= min && nums[i] <= max){
                len++;
                cnt += (len);
                
            }
            else {
                len = 0;
            }
        }

        return cnt;
    }
}