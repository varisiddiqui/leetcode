class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        

        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if((arr[mid]-(mid+1)) < k){
                low = mid+1;
            }
            else high = mid-1;
        }

        if(high == -1){
            return k;
        }

        int ans = arr[high]+k-(arr[high]-(high+1));
        return ans;


    }
}