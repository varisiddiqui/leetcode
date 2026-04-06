class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long low = 1;
        long high = maxSum;

        long ans = Long.MIN_VALUE;

        while(low <= high){
            long mid = low + (high-low)/2;

            if(isValid(n, index, maxSum, mid)){
                ans = Math.max(ans, mid);
                low = mid+1;
            }
            else high = mid-1;
        }
        return (int)ans;
    }

    public boolean isValid(int n, int index, int maxSum, long val){

        long sum=0;
        int leftA = index;
        int rightA = (n-1)-index;
        

        long lower = val-1;


        if(lower == rightA){
            sum = lower*(lower+1)/2;
        }
        else if(lower > rightA){
            long total = lower*(lower+1)/2;
            long sub = (lower-rightA)*(lower-rightA+1)/2;
            sum = total-sub;
        }
        else {
            long tot = lower*(lower+1)/2;
            sum = tot+(rightA-lower);
        }

        if(lower == leftA){
            sum += lower*(lower+1)/2;
        }
        else if(lower > leftA){
            long total = lower*(lower+1)/2;
            long sub = (lower-leftA)*(lower-leftA+1)/2;
            sum += total-sub;
        }
        else {
            long tot = lower*(lower+1)/2;
            sum += tot+(leftA-lower);
        }

       // System.out.println(val+" "+(sum<=maxSum)+" "+sum);

        return (sum+val) <= maxSum;



        
    }
}