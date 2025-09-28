class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;
        int left=-1;
        long sum1=0;
        long sum2=0;
        if(n==2) return Math.abs(nums[0]-nums[1]);
        
        for(int i=1; i<n; i++){
            sum1 += nums[i-1];
            if(nums[i-1] >= nums[i]){
                left = i-1;
                break;
            }
            
        }
         if(left ==-1){
            return Math.abs(sum1-nums[n-1]);
        }

        int right = -1;
    
        for(int i=n-2; i>=0; i--){
            sum2 += nums[i+1];
            if(nums[i] <= nums[i+1]){
                right = i+1;
                break;
            }
            
        }

        System.out.println(sum1+" "+sum2);
        


       
        if(right == -1){
            return Math.abs(sum2-nums[0]);
        }
        if(Math.abs(right-left) !=0 && Math.abs(right-left) != 1)
            return -1;

        if(left == right){
            long ans1 = Math.abs((sum1+nums[left])-sum2);
            long ans2 = Math.abs(sum1-(nums[right]+sum2));
            return Math.min(ans1, ans2);
        }
        return Math.abs(sum1-sum2);

        
        

        
        

        

        

        
        

        
    }
}