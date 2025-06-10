class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        for(int i=1; i<n; i++){
            int dig = nums[i];
            int pos=i;
            while(pos > 0 && nums[pos-1]>dig){
                pos--;
                nums[pos+1] = nums[pos];
            }
            nums[pos] = dig;
        }
        
    }
}