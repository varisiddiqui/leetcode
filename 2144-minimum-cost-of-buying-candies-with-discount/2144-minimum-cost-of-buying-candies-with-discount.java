class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int minCost=0;

        int i=n-1;
        
        for(i=n-1; i-2>=0; i=i-3){
            if(i-1>=0)
            minCost += cost[i]+cost[i-1];
        }
        
        if(i<=1){
            while(i>=0) minCost += cost[i--];
        }
        return minCost;
    }
}