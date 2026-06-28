class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        long pow[] = new long[n];

        pow[0]=1;
        for(int i=1; i<n; i++) pow[i] = pow[i-1]*2%1_000_000_007;

        //for(int num: nums) System.out.print(num+" ");

        int i=0;
        int j=n-1;

        long ans=0;

        while(i<=j){
            if(nums[i]+nums[j] <= target){
                ans += pow[j-i];
                ans %= 1_000_000_007;
                i++;
            }
            else{
                j--;
            }

           
        }
        return (int)ans;
    }
}