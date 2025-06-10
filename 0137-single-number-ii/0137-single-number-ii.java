class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n; i++){
            System.out.print(nums[i]+" ");
        }

        if(n==1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
       int c=1, ans=0;
        for(int i=0; i<n-1; i++){
            //min = Math.min(min, nums[i]);
            if(nums[i]==nums[i+1]) c++;
           else if(nums[i] != nums[i+1]){
            if(c==3){
                c=1;
            }
            else 
            return nums[i];
           }
               
           }
           
             
        
        return ans;
    }
}