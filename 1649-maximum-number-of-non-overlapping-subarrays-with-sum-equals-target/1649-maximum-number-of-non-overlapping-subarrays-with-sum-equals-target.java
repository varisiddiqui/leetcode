class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        int n = nums.length;

        int prefixSum=0;

        seen.add(0);
        int c=0;

        for(int num: nums){
            prefixSum += num;
            if(seen.contains(prefixSum-target)){
                c++;
                prefixSum=0;
                seen.clear();
                seen.add(0);
            }
            else{
                seen.add(prefixSum);
            }
        }
        return c;

    }
}