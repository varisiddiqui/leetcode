class Solution {
    public void moveZeroes(int[] nums) {
        int zero=0;
        int n = nums.length;
        
        int firstZero=0;

        for(int i=0; i<n; i++){
            while(firstZero<n && nums[firstZero] != 0) firstZero++;

            if(firstZero == n) break;
            if(nums[i] != 0 && firstZero < i){
                nums[firstZero] = nums[i];
                nums[i] =0;
            }
        }

    
    }
}