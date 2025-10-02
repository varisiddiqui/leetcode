class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int mid=nums.length;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>=0){
                mid = i;
                break;
            }
        }
       
        int i=0;

        while(k>0 && i<mid){
            nums[i] = -nums[i];
            k--;
            i++;
        }
        i=mid;



        boolean isremEven = (k%2==0)?true:false;
        int sum=0;
        for(int j=0; j<nums.length; j++)
        sum += nums[j];
        
        if(isremEven)
        return sum;
        else{
            if(mid<nums.length){
                int min = (mid-1>=0)? Math.min(Math.abs(nums[mid-1]), Math.abs(nums[mid])): nums[mid];
                return sum-2*min;
            }
            else{
                return sum-2*(nums[mid-1]);
            }
        }
        
       
    }
}