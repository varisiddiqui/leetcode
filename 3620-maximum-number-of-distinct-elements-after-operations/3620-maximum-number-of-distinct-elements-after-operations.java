class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        if(nums.length == 1) return 1;
        Arrays.sort(nums);

        int n = nums.length;
        TreeSet<Integer> seen = new TreeSet<>(Collections.reverseOrder());

       // for(int num: nums) seen.add(num);
        boolean enter = false;
        int count=0;

        for(int i=0; i<n; i++){
            if(!seen.contains(nums[i]-k)){
                seen.add(nums[i]-k);
            }
            else if(seen.first()+1>=nums[i]-k && seen.first()+1<=nums[i]+k){
                seen.add(seen.first()+1);               

            }
            
            
        }

        return seen.size();


    }
}