class Solution {
    public long maximumScore(int[] nums) {
        long prefixSum = 0;
        long min = Integer.MAX_VALUE;
        long ans=Integer.MIN_VALUE;

        int n = nums.length;

        for(int i=0; i<n-1; i++){
            prefixSum += nums[i];
        }
        min = nums[n-1];
        ans = Math.max(ans, prefixSum-min);
        for(int i=n-2; i>0; i--){
            // System.out.println(prefixSum+" "+min+" "+ans);
            prefixSum -= nums[i];
            min = Math.min(min, nums[i]);
           
            ans = Math.max(ans, prefixSum-min);
        
        }
       // System.out.println(prefixSum+" "+min+" "+ans);
        return ans;

    }
}