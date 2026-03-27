class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int maxNum=0;
        for(int i=0; i<n; i++) maxNum = Math.max(maxNum, nums[i]);

        int low=1;
        int high=maxNum;
        int ans=Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(isSufficient(mid, nums, threshold)){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;


    }

    public boolean isSufficient(int div, int nums[], int th){
        int sum=0;
        for(int i=0; i<nums.length; i++){
            if(sum > th) break;
            sum += Math.ceil(nums[i]/(double)div);
        }

        return sum<=th;
    }
}