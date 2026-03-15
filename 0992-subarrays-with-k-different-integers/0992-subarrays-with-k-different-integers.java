class Solution {

    public int util(int nums[], int k){
        int n = nums.length;
        int l=0, r=0;
        int no=0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        while(r<n){
            hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);

            while(hm.size() > k){
                if(hm.get(nums[l])-1 == 0) hm.remove(nums[l]);
                else hm.put(nums[l], hm.get(nums[l])-1);
                l++;
            }
            if(hm.size() <= k)
            no += (r-l+1);
            r++;

        }
        return no;
    }


    public int subarraysWithKDistinct(int[] nums, int k) {
        return util(nums, k) - util(nums, k-1);
    }
}