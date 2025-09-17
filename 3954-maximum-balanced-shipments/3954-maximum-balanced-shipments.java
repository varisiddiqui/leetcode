class Solution {
    public int maxBalancedShipments(int[] weight) {
        int max=0;
        int n = weight.length;
        int c=0;
        for(int i=0; i<n; i++){
            max = Math.max(max, weight[i]);
            if(weight[i]<max){
                c++;
                max=0;
            }
        }
        return c;
    }
}