class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans=0;
        for(int i=0; i<n; i++){
            int c=0;
            for(int j=i; j<n; j++){
                if(nums[j] == target) c++;

                if((j-i+1)/2 < c) ans++;
            }
        }
        return ans;
    }
}