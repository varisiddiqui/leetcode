class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;

        boolean isValid=true;

        for(int num: nums){
            if(num > 0) isValid = false;
        }

        if(isValid) return 0;

        int low=0;
        int high = queries.length-1;

        int ans = queries.length+1;


        while(low <= high){
            int mid = low + (high-low)/2;
            if(isValid(nums, queries, mid)){
                high = mid-1;
                ans = Math.min(ans, mid+1);
            }
            else low = mid+1;
        }

        return (ans == queries.length+1)? -1: ans;
    }

    public boolean isValid(int nums[], int queries[][], int k){
        int n = nums.length;

        int temp[] = new int[n];
        int t=0;

        for(int i=0; i<=k; i++){
            int q[] = queries[i];
            temp[q[0]] += q[2];

            if(q[1]+1 < n){
                temp[q[1]+1] -= q[2];
            } 
        }

        for(int i=0; i<n; i++){
            t += temp[i];
            if(t < nums[i]) return false;
        }
        return true;
    }

}