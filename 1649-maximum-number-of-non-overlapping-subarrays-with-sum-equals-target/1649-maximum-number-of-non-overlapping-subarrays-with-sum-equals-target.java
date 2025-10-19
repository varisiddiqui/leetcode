class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        int prefixSum=0;
        seen.add(0);
        int count=0; 
        for(int num: nums){
            prefixSum += num;

            if(seen.contains(prefixSum-target)){
                count++;
                seen.clear();
                seen.add(0);
                prefixSum=0;
            }else{
                seen.add(prefixSum);
            }
           
        }
        return count;
    }
}