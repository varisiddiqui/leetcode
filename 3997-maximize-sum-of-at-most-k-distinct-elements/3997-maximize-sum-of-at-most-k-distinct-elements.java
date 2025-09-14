class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        List<Integer> li = new ArrayList<>();
        for(Integer key: set){
            li.add(key);
            k--;
            if(k==0) break;
        }
        int ans[] = new int[li.size()];
        for(int i=0; i<ans.length; i++){
            ans[i]=li.get(i);

        }
        return ans;
    }
}