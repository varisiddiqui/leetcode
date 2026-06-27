class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int i=0;

        subseq(0, nums, ans, new ArrayList<>());
        return ans;
        

    }

    public void subseq(int i, int nums[], List<List<Integer>> ans, List<Integer> li){
        if(i == nums.length) {
            ans.add(li);
            return;
        }

        li.add(nums[i]);
        subseq(i+1, nums, ans, new ArrayList<>(li));
        li.remove(li.size()-1);
        subseq(i+1, nums, ans, new ArrayList<>(li));
    }
}