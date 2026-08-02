class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subseq(new ArrayList<>(), 0, nums);

        return ans;


    }

    public void subseq(List<Integer> li, int idx, int nums[]){
        if(idx == nums.length){
            ans.add(new ArrayList<>(li));
            return;
        }

        subseq(li, idx+1, nums);

        li.add(nums[idx]);

        subseq(li, idx+1, nums);

        li.remove(li.size()-1);

    }
}