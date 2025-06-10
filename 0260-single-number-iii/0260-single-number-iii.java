class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        int ans[] = new int[2];
        int i=0;
        for(Integer key: hm.keySet()){
            if(hm.get(key) == 1)
            ans[i++] = key;
        }
        return ans;
    }
}