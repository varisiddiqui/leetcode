class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long totCost=0;
        
        if(cost1+cost2 >= costBoth){
            long minCan = Math.min(need1, need2);
            totCost += minCan*1L*costBoth;
            need1 -= minCan;
            need2 -= minCan;
            if(need1>0){
                totCost += need1*1L*Math.min(cost1, costBoth);
            }
            if(need2 > 0){
                totCost += need2*1L*Math.min(cost2, costBoth);
            }
        }
        else{
            totCost += need1*1L*Math.min(cost1, costBoth);
            totCost += need2*1L*Math.min(cost2, costBoth);

        }

        return totCost;
        
    }
}