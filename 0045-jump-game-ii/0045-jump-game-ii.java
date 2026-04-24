class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxEnd=0;
        int currEnd=0;
        int count=0;
        

        for(int i=0; i<n; i++){
            
            if(i>currEnd){
                count++;
                currEnd = maxEnd;
            }
            maxEnd = Math.max(maxEnd, (i+nums[i]));
            
        }

        return count;
    }
}