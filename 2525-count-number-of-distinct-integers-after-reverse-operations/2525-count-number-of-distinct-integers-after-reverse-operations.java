class Solution {
    public int countDistinctIntegers(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(nums[i]);
            int dup = nums[i];
            int rev=0;
            while(dup>0){
                int d = dup%10;
                rev = rev*10+d;
                dup /= 10;
            }
            set.add(rev);
        }
        return set.size();
    }
}