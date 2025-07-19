class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            else
            maxProfit = Math.max(maxProfit, prices[i]-min);
        }
        return maxProfit;
    }
}

/*You optimize it to O(1) space by just using variables instead of arrays.

This is an example of space-optimized 1D DP.*/

/*A problem is often tagged as DP when:

You're breaking the problem into smaller optimal subproblems

Reusing solutions of previous subproblems to build up

Whether or not it's using a full DP array or recursion*/

/*just remembering the past*/

