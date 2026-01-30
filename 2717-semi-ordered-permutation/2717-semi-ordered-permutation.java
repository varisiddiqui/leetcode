class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int one=-1;
        int last=-1;

        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == 1) one=i;
            if(nums[i] == n) last = i;
        }

        int total = (one-0)+(n-1-last);

        return (one < last)?total: total-1;

        
    }
}