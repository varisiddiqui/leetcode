class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        int n = nums.length;

        for(int i=0; i<n; i++) hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);

        for(Integer key: hm.keySet()){
            freq.put(hm.get(key), freq.getOrDefault(hm.get(key), 0)+1);
        }

        for(int i=0; i<n; i++){
            int f = hm.get(nums[i]);
            int noOfElement = freq.get(f);
            if(noOfElement == 1) return nums[i];
        }

        return -1;


    }
}