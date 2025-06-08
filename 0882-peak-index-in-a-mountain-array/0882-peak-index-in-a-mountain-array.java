class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        if(n == 1) return 0;
        if(n == 2){
            if(nums[0]<nums[1]) return 1;
            return 0;
        }
        int ans=0;
        while(start<=end){
            int mid = start + ((end-start)/2);
            
            if((mid-1 >= 0 && mid+1<n) && (nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1])){
                
                ans = mid;
                break;
            }
            else if((mid-1>=0 && mid+1>=n) && (nums[mid-1] < nums[mid])){
                
                    ans = mid;
                    break;
                

            }

            else if((mid-1<0 && mid+1<n) && (nums[mid] < nums[mid+1])){
               
                    ans = mid+1;
                    break;
                
            }

            else if (nums[mid] < nums[mid+1]){
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return ans;
    }
}