class Solution {
    public int majorityElement(int[] nums) {
        int count=1;
        int prev=nums[0];
        int n=nums.length;
        for(int i=1; i<n; i++){
            if(prev != nums[i]){
                count--;
                if(count==0){
                    count=1;
                    prev=nums[i];
                }
            }
            else{
                count++;
               
            }
        }
        return prev;
        
    }
}