class Solution {
    public int findKthLargest(int[] nums, int k) {
        int min = Integer.MAX_VALUE-1;
        int max = Integer.MIN_VALUE+1;
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }
        int ans = -1;
        int totMaxFreq=0;
        for(int i=max ; i>=min; i--){
            if(hm.containsKey(i)){
                totMaxFreq += hm.get(i);
                if(k<=totMaxFreq){
                    ans = i;
                    break;
                }
                
                   
                

            }
        }
        return ans;
    }
}