class Solution {
    public int findDuplicate(int[] nums) {
       int start = nums[0];
       int fast = nums[0];
       do{
        start = nums[start];
        fast = nums[nums[fast]];
       } while (start != fast);
       start = nums[0];
       while(start != fast){
        start = nums[start];
        fast = nums[fast];
       }
       return start;
           }
}