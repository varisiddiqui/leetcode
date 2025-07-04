class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n= nums.length;
        int i=0, j=n-1;
        if(n==1) return 0;

       
            while((i+1)<n && nums[i]<=nums[i+1]){
                i++;
            }

            if(i+1 == n) return 0; //already sorted

            while((j-1)>=0 && nums[j-1]<=nums[j]){
                j--;
            }
            
        
        int min=Integer.MAX_VALUE;
        int max =Integer.MIN_VALUE;
        for(int l=i; l<=j; l++){
            min = Math.min(min, nums[l]);
            max = Math.max(max, nums[l]);
        }

        int l=0;
        while(nums[l]<=min){
            l++;
        }

        int r=n-1;
        while(nums[r]>=max){
            r--;
        }


        return r-l+1;
    }
}