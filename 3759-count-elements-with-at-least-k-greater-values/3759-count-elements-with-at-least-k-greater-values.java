class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        if(k==0) return n;
        Arrays.sort(nums);
        int x = nums[n-k];
        int count=0;
        for(int num: nums){
            if(num<x) count++;
            else break;
        }
        return count;
    }
}