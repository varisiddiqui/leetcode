class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int cp = prices[0];
        int profit=0;

        for(int i=1; i<n; i++){
            if(cp < prices[i]){
                profit += prices[i]-cp;
                cp = prices[i];
            } 
            else if(cp > prices[i]) cp = prices[i];
            
            
        }
        return profit;
    }
}