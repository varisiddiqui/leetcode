class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int i=0;
        while(i<n-1 && nums[i]<nums[i+1]) i++;

        int ans1 = bin(0, i, nums, target);
        int ans2 = bin(i+1, n-1, nums, target);

        if(ans1 != -1) return ans1;
        return ans2;
    }

    public int bin(int i, int j, int nums[], int target){
        int low =i;
        int high=j;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}