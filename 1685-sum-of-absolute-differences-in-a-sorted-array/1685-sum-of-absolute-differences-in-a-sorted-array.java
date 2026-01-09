class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int suffix=0;
        int prefix=0;
        
        for(int i=0; i<n; i++){
           suffix += nums[i];
        }

        int diff[] = new int[n];
       // diff[0] = prefix[1]-((n-1)*nums[0])
        for(int i=0; i<n; i++){
            suffix -= nums[i];
            if(i-1>=0){
                diff[i] += (i*nums[i] - prefix);
               
            }
            if(i+1<n){
                diff[i] += (suffix - ((n-i-1)*nums[i]));
              
            }
            prefix += nums[i];
  
        }
        return diff;
    }
}