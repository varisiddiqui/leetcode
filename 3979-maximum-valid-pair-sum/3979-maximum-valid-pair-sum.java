class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;

        long leftMax=nums[0];
        long rightMax=0;

        int i=0;
        int j=0+k;

        long ans=0;

        int nextGreater[] = new int[n];

        nextGreater[n-1] = nums[n-1];

        

        for(int l=n-1; l>=j; l--) nextGreater[l] = Math.max(nextGreater[l], nums[l]);

        while(j<n){
            ans = Math.max(ans, leftMax+nextGreater[j]);
            i++;
            leftMax = Math.max(leftMax, nums[i]);
            j++;
        }

        return (int)ans;


    }
}