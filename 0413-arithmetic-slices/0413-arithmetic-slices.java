class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;

        if(n<3) return 0;

        long diff = (long)nums[1] - (long)nums[0];

        int cnt=1;

        int ans=0;

        for(int i=2; i<n; i++){
            if((long)nums[i] - (long)nums[i-1] == diff){
                ans += cnt;
                cnt++;
            }
            else {
                    diff = (long)nums[i] - (long)nums[i-1];
                    cnt = 1;
            }
        }

        return ans;
    }
}