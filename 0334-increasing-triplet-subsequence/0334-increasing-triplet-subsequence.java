class Solution {
    public boolean increasingTriplet(int[] nums) {
        int firstMin=Integer.MAX_VALUE;
        int secondMin=Integer.MAX_VALUE;

        for(int num: nums){
            if(firstMin >= num){
                firstMin = num;
            }
            else if(secondMin >= num){
                secondMin = num;
            }
            else return true;
        }
        return false;
    }
}