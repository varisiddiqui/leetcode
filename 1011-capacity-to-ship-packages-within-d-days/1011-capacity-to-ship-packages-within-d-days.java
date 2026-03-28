class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int sum=0;
        int max=0;

        for(int i=0; i<n; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }

        System.out.println(sum);

        int low = max;
        int high = sum;
        int ans=Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(isSufficient(mid, weights, days)){
                ans = Math.min(ans, mid);
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;


    }


    public boolean isSufficient(int cap, int weights[], int days){
        int n = weights.length;
        int sum=0;
        int d=0;
       
       for(int i=0; i<n; i++){
        if(weights[i]>cap) return false;
         sum += weights[i];

         if(sum > cap){
            d++;
            sum=weights[i];
         }
            
       }
       if(sum<=cap) d++;
      // System.out.println(cap+" "+d);

       return d<=days;

    }

    
}