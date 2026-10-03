class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        int low = 1;
        int high = piles[n-1];
        int min=Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(isSufficient(mid, piles, h)){
                min=Math.min(min, mid);
                high = mid-1;
            }
            else low = mid+1;
        }
        return min;
    }

    public boolean isSufficient(int k, int piles[], int h){
        int totalHr=0;
        for(int i=0; i<piles.length; i++){
            if(piles[i] <= k) totalHr++;
            else
            totalHr += Math.ceil(piles[i]/(double)k);
        }

        //System.out.println(k+" "+totalHr);

        return (totalHr <= h);
    } 
}