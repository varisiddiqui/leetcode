class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;

        if(n == 3||n==2) return Math.abs(stones[0]-stones[n-1]);
        int min = Integer.MIN_VALUE;

        for(int i=0; i<n-2; i++){
            min = Math.max(min, stones[i+2]-stones[i]);

        }
        return min;
    }
}