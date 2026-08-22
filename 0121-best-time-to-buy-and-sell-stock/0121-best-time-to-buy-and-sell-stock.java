class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;

        int cp=prices[0];

        for(int i=1; i<n; i++){
            cp = Math.min(cp, prices[i]);
            if(prices[i] > cp){
                ans = Math.max(ans, prices[i]-cp);
            }
        }
        return ans;
    }
}