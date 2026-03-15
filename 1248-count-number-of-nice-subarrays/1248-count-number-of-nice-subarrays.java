class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i]%2 != 0) nums[i]=1;
            else nums[i]=0;
        }

        int no=0;
        int sum=0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i=0; i<n; i++){
            sum += nums[i];
            if(hm.containsKey(sum-k)){
                no += hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum,0)+1);
        }
        return no;
    }
}