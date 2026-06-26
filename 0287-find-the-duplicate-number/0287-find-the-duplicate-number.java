class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        int i=1;

        while(i<n){
            int currIdx = i;
            int actualIdx=nums[i];
            if(currIdx != actualIdx){
                while(currIdx != actualIdx){ //now place nums[i] at ele idx
                    int temp = nums[actualIdx];
                    if(temp == actualIdx) return actualIdx;
                    nums[actualIdx] = actualIdx;
                    nums[currIdx] = temp;
                    actualIdx = nums[i];
                }
            }
            i++;
        }

        return nums[0];
    }
}