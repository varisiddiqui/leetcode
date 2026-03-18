class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        boolean found = false;
        int low=0;
        int high = n-1;
        int start=-1;
        int end = -1;

        //for starting
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] < target){
                low = mid+1;
            }

            else {
                if(!found && nums[mid] == target) found = true; 
                start = mid;
                high = mid-1;
            }
        }
        if(!found) return new int[]{-1, -1};
        

        low = 0;
        high = n-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] <= target){
                end = mid;
                low = mid+1;
            }
            else{
            high = mid-1;
            }
        }
        if(!found) return new int[]{-1, -1};
        return new int[]{start, end};
    }
}