class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0]=nums[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1]*nums[i];
        }
        suffix[n-1]=nums[n-1];
        for(int i=n-2; i>=0; i--){
            suffix[i] = suffix[i+1]*nums[i];
        }

        int ans[] = new int[n];
        for(int i=0; i<n; i++){
            int product = 1;
            if(i-1>=0){
                product *= prefix[i-1];
            }
            if(i+1<n){
                product *= suffix[i+1];
            }
            ans[i]=product;
        } 
        return ans;       
    }
}