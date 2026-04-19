class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int op=0;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            int min = Integer.MAX_VALUE;
            for(int j=0; j<n; j++){
                if(nums[j]>0) min = Math.min(min, nums[j]);
            }
            if(min == Integer.MAX_VALUE) continue;
            else op++;
            for(int j=0; j<n; j++){
                if(nums[j]>0) nums[j] -= min;
            }
        }
        return op;
    }

}