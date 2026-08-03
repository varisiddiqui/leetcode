class Solution {
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subset(new ArrayList<>(), nums, 0);
        return new ArrayList<>(set);
    }

    public void subset(List<Integer> li, int nums[], int idx){
        if(idx == nums.length){
            set.add(new ArrayList<>(li));
            return;
        }

        //pick
        li.add(nums[idx]);
        subset(li, nums, idx+1);
        li.remove(li.size()-1);

        subset(li, nums, idx+1);
    }


}