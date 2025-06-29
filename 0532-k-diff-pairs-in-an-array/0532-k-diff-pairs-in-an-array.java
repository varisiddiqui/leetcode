class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> paired = new HashMap<>();
     
        for(int i=0; i<n; i++)
        hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        int count=0;
        if(k==0){
            for(Integer key: hm.keySet()){
                if(hm.get(key)>1) count++;
            }
            return count;
        }
        else{
            for(int i=0; i<n; i++){
                if(hm.containsKey(nums[i]+k) && !paired.containsKey(nums[i])){
                    paired.put(nums[i], nums[i]+k);
                     count++;

                }
            }
            return count;
        }
    }
}