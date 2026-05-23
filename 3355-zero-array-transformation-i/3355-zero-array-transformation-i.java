class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;

        int temp[] = new int[n];

        for(int q[] : queries){
            temp[q[0]] += 1;
            if(q[1]+1 < n){
                temp[q[1]+1] -= 1;
            }
        }

        int t=0;

        for(int i=0; i<n; i++){
            t += temp[i];

            if(nums[i] > t) return false;
        }
        return true;
    }
}