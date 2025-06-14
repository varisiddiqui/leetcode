class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if(n==1) return true;
        int posToChange=-1;
        for(int i=0; i<n-1; i++){
            if(nums[i]>nums[i+1]){
                posToChange = i;
                break;
            }

        }
        if(posToChange == -1) return true;
        //case-1
        int num_pos = nums[posToChange];
        nums[posToChange] = nums[posToChange+1];
        boolean pass1 = true;
        for(int i=0; i<n-1; i++){
            if(nums[i]>nums[i+1])
            pass1 = false;
        }

        //case-2
        nums[posToChange] = num_pos;
        nums[posToChange+1] = num_pos;
        boolean pass2 = true;
        for(int i=0; i<n-1; i++){
            if(nums[i]>nums[i+1])
            pass2 = false;
        }
        return pass1||pass2;
    }
}