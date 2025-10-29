class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }

        int target = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(0, -1);
        int sum=0;
        int max=0;
        for(int i=0; i<n; i++){
             sum += nums[i];
            if(hm.containsKey(sum-target)){
                max = Math.max(max, i-(hm.get(sum-target)));
            }
           
            hm.putIfAbsent(sum, i);

        }
        return max;
    }
}