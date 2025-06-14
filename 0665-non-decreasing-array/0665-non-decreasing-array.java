class Solution {
    public boolean checkPossibility(int[] nums) {
        int c = 0;
        int n = nums.length;
        if(n==1) return true;
        for(int i=0; i<n-1; i++){
            if(c>1) return false;

            if((nums[i]>nums[i+1])){
                if((i-1) < 0){
                    nums[i] = nums[i+1];
                    c++;
                } 
                else if((i-1>=0) && nums[i-1]<=nums[i+1]){
                    c++;
                }
                else{
                    nums[i+1] = nums[i];
                    c++;
                }
            }
        }
        if(c>1) return false;
        return true;
    }
}