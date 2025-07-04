class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int diff[] = new int[n];
        diff[0] = gas[0]-cost[0];
        for(int i=1; i<n; i++){
            diff[i] = diff[i-1] + (gas[i] - cost[i]);
        }
        int ans = -1;
        int firstPos = -1;
        for(int i=n-1; i>=0; i--){
            if(diff[i] < 0){
                firstPos = i;
                break;
            }
        }
        
        if(firstPos == -1) return 0;
        if(firstPos == n-1) return -1;

        int sum = 0;
        boolean flag = false;
        for(int i=firstPos; i>=0; i--){
            if(gas[i]-cost[i] < 0 && !flag){
                sum += (gas[i]-cost[i]);  
                ans = i+1;
                flag = true;              
            }
            else if(flag){
                sum += (gas[i]-cost[i]);  
            }
           
                
                           
            
            if(sum >=0){
                ans = i;
            }
        }
        return ans;
        
        
    }
}