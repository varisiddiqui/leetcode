class Solution {
    public int minimumSwaps(int[] nums) {
        int n=nums.length;
        int swap=0;

        int i=0;
        int j=n-1;

        while(i<j){
            while(j>i && nums[j] == 0) j--;
            while(i<j && nums[i] != 0) i++;

            if(i<j) {
                swap++;
                i++;
                j--;
            }

        }

        
        return swap;
    }
}