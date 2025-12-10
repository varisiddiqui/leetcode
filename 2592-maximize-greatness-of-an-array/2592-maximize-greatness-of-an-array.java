class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n==1) return 0;
        int i=0;
        int j=1, count=0;
        while(j<n){
            if(nums[i]<nums[j]){
                count++;
                i++;
                
            } 
            j++;
        }
        return count;
        

    }
}