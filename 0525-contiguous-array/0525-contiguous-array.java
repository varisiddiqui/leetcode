class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
       
        int target = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(0, -1);
        int sum=0;
        int max=0;
        for(int i=0; i<n; i++){
             sum += (nums[i] == 1)? 1: -1;
            if(hm.containsKey(sum-target)){
                max = Math.max(max, i-(hm.get(sum-target)));
            }
           
            hm.putIfAbsent(sum, i);

        }
        return max;
    }
}