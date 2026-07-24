class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        if(n==1) return 0;

        int cost=0;

        
        int totalTime=neededTime[0];
        int maxCost=neededTime[0];
        for(int i=1; i<n; i++){
            if(colors.charAt(i) == colors.charAt(i-1)){ //same
                totalTime += neededTime[i];
                maxCost = Math.max(maxCost, neededTime[i]);
            }
            else {
                if(totalTime != maxCost){
                    cost += (totalTime-maxCost);
                }

                maxCost=neededTime[i];
                totalTime=neededTime[i];
            }
        }
        return cost += (totalTime-maxCost);
    }
}