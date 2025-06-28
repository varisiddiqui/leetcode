class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);

        int n = maximumHeight.length;
        System.out.println(n);
        if(maximumHeight[n-1]<n) return -1;
        long sum=maximumHeight[n-1];

        for(int i=n-2; i>=0; i--){
            if(maximumHeight[i]>=(i+1)){
                if(maximumHeight[i]<maximumHeight[i+1])
                sum += (long)maximumHeight[i];
                else{
                    maximumHeight[i]=maximumHeight[i+1]-1;;
                    
                    sum += (long)maximumHeight[i];
                     
                }
                
            }
            
            else return -1;
        }
        return sum;
    }
}