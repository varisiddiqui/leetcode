class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        prefix[0]=nums[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1]+nums[i];
        }

        int diff[] = new int[n];
       // diff[0] = prefix[1]-((n-1)*nums[0])
        for(int i=0; i<n; i++){
            if(i-1>=0){
                diff[i] += (i*nums[i] - prefix[i-1]);
                System.out.print(diff[i]+" ");
            }
            if(i+1<n){
                diff[i] += ((prefix[n-1]-prefix[i]) - ((n-i-1)*nums[i]));
                System.out.print(diff[i]+" ");
            }
  
        }
        return diff;
    }
}