class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;

        int arr[][] = new int[n][3];

        for(int i=0; i<n; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(a[0], b[0]);
        };

        Arrays.sort(arr, cmp);

        int dp[] = new int[n+1];

       

        for(int i=n-1; i>=0; i--){
            //take 
            int curr_endT = arr[i][1];
            int next = bin(arr, curr_endT);
            dp[i] = Math.max(dp[i], arr[i][2] + dp[next]);

            //not take
            dp[i] = Math.max(dp[i], dp[i+1]);
        }

    

        return dp[0];
    }

    public int bin(int arr[][], int endTime){
        int low = 0;
        int high = arr.length-1;

        int ans=arr.length;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid][0] >= endTime){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }

        return ans;
    }
}