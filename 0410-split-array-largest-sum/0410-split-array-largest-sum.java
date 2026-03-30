class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low=Integer.MAX_VALUE;
        int high=0;
        for(int i=0; i<n; i++){
            low = Math.min(low, nums[i]);
            high += nums[i];
        }
        int ans=Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(isSufficient(mid, nums, k)){
                ans = Math.min(ans, mid);
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;


    }

    public boolean isSufficient(int limit, int nums[], int k){
        int c=0;
        int sum=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > limit) return false;
            sum += nums[i];
            if(sum > limit){
                c++;
                sum = nums[i];
            }
        }

        if(sum <= limit) c++;

        return c<=k;
    }

}