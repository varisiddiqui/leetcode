class Solution {
    public int util(int nums[], int k){
        int odd=0;

        int r=0, l=0;
        int n = nums.length;

        int sum=0;

        while(r<n){
            if(nums[r]%2 != 0) odd++;

            while(odd > k){
                if(nums[l]%2 != 0){
                    odd--;
                }
                l++;
            }

            sum += (r-l+1);
            r++;
        }
        return sum; 
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return util(nums, k) - util(nums, k-1);
    }
}