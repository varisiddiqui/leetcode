class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        if(nums.length == 1) return 1;
        Arrays.sort(nums);

        int n = nums.length;
        //TreeSet<Integer> seen = new TreeSet<>(Collections.reverseOrder());

       // for(int num: nums) seen.add(num);
       // boolean enter = false;
        int count=1;
        int possible=0;
        int lastUsed=nums[0]-k;

        for(int i=1; i<n; i++){
            possible = Math.max(lastUsed+1, nums[i]-k);
            if(possible<=nums[i]+k){
                count++;
                lastUsed = possible;
            }
            
            
            
        }

        return count;


    }
}