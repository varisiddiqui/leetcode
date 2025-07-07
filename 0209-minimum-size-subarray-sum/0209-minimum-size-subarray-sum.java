class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        long sum=0;
        int i=0, j=0;
        int count=0;
        int len = Integer.MAX_VALUE;
    
        while(i<n && j<n){
            while(j<n && sum<target){
                sum += nums[j];
                j++;
                count++;
            }
            if(i==0 && j==n && sum<target) return 0;
            if(count>0 && sum>=target)
            len = Math.min(len, count);
            while(i<n && sum>=target){
                sum -= nums[i];
                count--;
                i++;
            }
            if(count+1>0 ){
                 len = Math.min(len, count+1);
            }
           
     }
     return len;
    }
}