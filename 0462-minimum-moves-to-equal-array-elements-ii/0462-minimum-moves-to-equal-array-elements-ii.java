class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = nums[n/2];
        int moves=0;
        for(int num: nums){
            moves += Math.abs(num-mid);
        }

        if(n%2 == 0){
            int moves2 = 0;
            int mid2 = nums[(n/2)-1];
            for(int num: nums){
                moves2 += Math.abs(num-mid2);
            }
            moves = Math.min(moves, moves2);
        }
        return moves;
    }
}