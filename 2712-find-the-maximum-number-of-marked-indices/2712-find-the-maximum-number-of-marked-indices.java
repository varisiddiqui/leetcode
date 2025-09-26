class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int start_idx=0;
        int last_idx=n/2;

        

        if(2*nums[0] > nums[n-1]) return 0;
        if(n==1) return 0;

        

        

//        System.out.println(start_idx);

        int count=0;

        while(start_idx<n/2 && last_idx<n){
            if(2*nums[start_idx] <= nums[last_idx]){
                count += 2;
                start_idx++;
                last_idx++;
            }
            else{
                last_idx++;
            }
        }
        return count;
    }
}