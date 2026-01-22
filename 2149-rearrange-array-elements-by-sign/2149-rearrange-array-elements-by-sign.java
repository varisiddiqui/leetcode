class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos=0;
        int neg=0;

        int n = nums.length;

        int ans[] = new int[n];
        int k=0;

        while(pos<n || neg<n){
            while(pos<n && nums[pos] < 0) pos++;
             if(pos<n) ans[k++]=nums[pos++];
          
             
            while(neg<n && nums[neg] > 0) neg++;
            if(neg < n) ans[k++]=nums[neg++];
            

            
        }

        return ans;
    }
}