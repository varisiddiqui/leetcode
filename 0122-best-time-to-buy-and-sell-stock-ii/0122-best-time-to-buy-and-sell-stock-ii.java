class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int n = prices.length;
        if(n == 1) return 0;

        int totProfit=0;

        for(int i=1; i<n; i++){
            if(min > prices[i]){
                min = prices[i];
            }
            else{
                totProfit += prices[i]-min;
                min = prices[i];
            }
        }
        return totProfit;
    }

}