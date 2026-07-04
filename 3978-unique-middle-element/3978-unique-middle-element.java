class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length;

        int midEl = nums[n/2];

        boolean found=false;

        for(int num: nums){
            if(num == midEl && !found) found = true;
            else if(num == midEl) return false;
        }
        return true;
    }
}