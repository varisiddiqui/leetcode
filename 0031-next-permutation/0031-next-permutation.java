class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int i=n-2;
        int nextLarger = -1;
       
        

        while(i>=0){
            if(nums[i] < nums[i+1]){
                nextLarger = i+1;
                int itr=i+1;
                while(itr<n){
                    if(nums[i] < nums[itr]){
                        if(nums[nextLarger] > nums[itr]){
                            nextLarger = itr;
                        }
                        
                    }
                    else break;
                    itr++;
                }
                int temp = nums[i];
                nums[i] = nums[nextLarger];
                nums[nextLarger] = temp;
                Arrays.sort(nums, i+1, n);
                break;
            }   
            i--;         
        }

        if(nextLarger == -1) 
        Arrays.sort(nums);
    }
}