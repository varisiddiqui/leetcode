class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        int n = maximumHeight.length;
        Arrays.sort(maximumHeight);
        long sum=maximumHeight[n-1];
        if(maximumHeight[n-1] < n) return -1;

        for(int i=n-2; i>=0; i--){
            if(maximumHeight[i]<(i+1)){
                return -1;
            }
            else{
                if(maximumHeight[i]>=(i+1)){
                    if(maximumHeight[i]<maximumHeight[i+1]){
                        sum += maximumHeight[i];
                    }
                    else if(maximumHeight[i]>=maximumHeight[i+1]){
                        if(maximumHeight[i+1]-1 <=0) return -1;
                        else {
                            maximumHeight[i]=maximumHeight[i+1]-1;
                            sum += maximumHeight[i];
                        }
                        
                    }
                    
                }
                else 
                return -1;
            
                
            }
        }
        return sum;
    }
}