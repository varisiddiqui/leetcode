class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isNot_inc= false;
        boolean isNot_dec= false;

        int n = nums.length;

        for(int i=0; i<n; i++){
            if(i+1<n){
                if(nums[i]>nums[i+1]){
                    isNot_inc=true;
                    break;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(i+1<n){
                if(nums[i]<nums[i+1]){
                    isNot_dec=true;
                    break;
                }
            }
        }

        if(isNot_inc && isNot_dec) return false;
        return true;
    }
}