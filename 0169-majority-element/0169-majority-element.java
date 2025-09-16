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
        System.out.println(prev);
        count=0;
        for(int i=0; i<n; i++){
            if(prev==nums[i]){
                count++;
            }
        }
        if(count>(int)Math.ceil(n/2)) return prev;
        return 0;
    }
}