class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int n = piles.length;

        long low=piles[0];
        long high=piles[n-1];

        long ans = piles[n-1];

        while(low <= high){
            long mid = low + (high-low)/2;

            int idx = bin(piles, mid);

            int left_hr = (piles[idx] > mid)? idx+2: idx+1;

            int right_hr=0;

            for(int i=idx+1; i<n; i++){
                right_hr += (piles[i]/mid);
                if(piles[i] % mid >0) right_hr++;
            }

            int total_hr = left_hr + right_hr;

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