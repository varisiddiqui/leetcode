class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for(Integer key: hm.keySet()){
            if(hm.get(key) == 1) return key;
        }
        return 0;
    }
}