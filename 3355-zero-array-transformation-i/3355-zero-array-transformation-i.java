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

        for(int i=1; i<n; i++) temp[i] = temp[i-1]+temp[i];

        for(int i=0; i<n; i++){
            if(nums[i] > temp[i]) return false;
        }
        return true;
    }
}