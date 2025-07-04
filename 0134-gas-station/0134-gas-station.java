class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum=0, count=0;
        int idx=-1;
        boolean enter = false;
        for(int i=0; i<2*n; i++){
           
            if(count==n) break;
            if(sum+(gas[i%n]-cost[i%n]) >= 0){
                sum += (gas[i%n]-cost[i%n]);
                count++;
            }
            else{
                sum=0;
                count=0;
                idx=(i+1)%n;
                enter = true;
            }

           

        }
        if(count==n && !enter) return 0;
        else if (count == n) return idx;
        return -1;

        
    }
}