class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=0; i<n; i++){
            min = Math.min(min, nums[i]);
        }

        int moves=0;
        for(int i=0; i<n; i++) moves += nums[i]-min;
        return moves;
    }
}