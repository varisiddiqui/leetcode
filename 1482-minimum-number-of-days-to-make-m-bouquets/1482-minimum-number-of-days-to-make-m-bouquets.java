class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int maxD=0;
        int n = bloomDay.length;

        for(int i=0; i<n; i++) maxD = Math.max(maxD, bloomDay[i]);

        int low = 1;
        int high = maxD;

        int ans=Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(isSufficient(mid, bloomDay, m, k)){
                ans = Math.min(ans, mid);
                high = mid-1;
            }
            else low = mid+1;
        }

        return ans==Integer.MAX_VALUE?-1: ans;



    }

    public boolean isSufficient(int day, int bloomDay[], int m, int k){
        int i=0;
        int n = bloomDay.length;
        int count=0;
//System.out.println(day+" "+count);

        while(i<n){
            int j=i;
            while(j<n && (j-i)<k){
                if(bloomDay[j] > day) break;
                j++;
            }
            if((j-i)==k){
                count++;
                i=j;
            }
            else i++;
        }
       // System.out.println(day+" "+count);

        return count>=m;
    }
}