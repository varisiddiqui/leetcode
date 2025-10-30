class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n==1) return 1;

        long prefix[] = new long[n];
        prefix[0] = nums[0];

        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        int count=0;
        int left=0;
        long s=0;

        for(int i=0; i<n; i++){
            s += nums[i];
            int curr = nums[i];
            
            //long target = s;

       
            while((i-left+1)*(long)curr - s > k){
                s -= nums[left];
                left++;
            }
            count = Math.max(count, i-left+1);
        }
        return count;
    }
}