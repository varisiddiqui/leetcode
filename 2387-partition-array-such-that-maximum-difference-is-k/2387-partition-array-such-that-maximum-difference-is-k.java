class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return 1;
        Arrays.sort(nums);
        int part=0;
        int min=nums[0];
        for(int i=1; i<n; i++){
            if(nums[i]-min <= k){
                continue;
            }
            else{
                part++;
                min = nums[i];
            }
        }
        return part+1;
    }
}