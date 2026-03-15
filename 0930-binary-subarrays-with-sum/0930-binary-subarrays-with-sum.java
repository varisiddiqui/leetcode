class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(0, 1);

        int no=0;
        int n = nums.length;
        int sum=0;

        for(int i=0; i<n; i++){
            sum += nums[i];
            if(hm.containsKey(sum-goal)){
                no += hm.get(sum-goal);
            }
            hm.put(sum, hm.getOrDefault(sum,0)+1);
        }
        return no;
    }
}