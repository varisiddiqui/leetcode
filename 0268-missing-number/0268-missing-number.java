class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        

        long currSum = 0;

        for(int num: nums){
            currSum += num*1L;
        }

        long sum = (n*(n+1))/2;

        return (int)(sum-currSum);



    }
}