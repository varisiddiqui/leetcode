class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int n = piles.length;

        long low=1;
        long high=piles[n-1];

        long ans = piles[n-1];

        while(low <= high){
            long mid = low + (high-low)/2;

            int idx = bin(piles, mid);

            long left_hr = idx;

            long right_hr=0;

            for(int i=idx; i<n; i++){
                right_hr += (piles[i]/mid);
                if(piles[i] % mid >0) right_hr++;
            }

            long total_hr = left_hr + right_hr;

            if(total_hr <= h){
                high = mid-1;
                ans = mid;
            }
            else low = mid+1;
        }

        return (int)ans;


    }

    public int bin(int piles[], long key){
        int low = 0;
        int n = piles.length;
        int high = n-1;

        int ans = n;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(piles[mid] >= key) {
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }

        return ans;
    }
}