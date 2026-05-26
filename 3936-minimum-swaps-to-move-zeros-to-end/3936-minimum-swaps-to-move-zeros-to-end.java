class Solution {
    public int minimumSwaps(int[] nums) {
        int n=nums.length;
        int swap=0;

        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                for(int j=n-1; j>i; j--){
                    if(nums[j] != 0){
                        nums[j]=0;
                        swap++;
                        break;
                    }
                }
            }
        }
        return swap;
    }
}