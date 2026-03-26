class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int leftSz=0;
        int rightSz=0;
        while(low <= high){
            int mid = low + (high - low)/2;
            leftSz=0;
            rightSz=0;

           if(mid-1>=0 && nums[mid-1] == nums[mid]){
              rightSz = (high)-(mid-1)+1;
              leftSz = (mid)-low+1;

              if(leftSz%2==0){
                low = mid+1;
              }
              else high = mid-2;
              
           }
           else if(mid+1<n && nums[mid] == nums[mid+1]){
            rightSz = (high)-mid+1;
            leftSz = (mid+1)-low+1;

            if(leftSz%2==0){
                low= mid+2;
            }
            else high = mid-1;
           }

           else return nums[mid];

        }
        return 0;
    }
}