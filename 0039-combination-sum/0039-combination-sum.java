class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int tar=0;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        tar = target;

        subseq(new ArrayList<>(), 0, 0, nums);

        return ans;
    }

    public void subseq(List<Integer> li, int idx, int sum, int nums[]){
        if(idx == nums.length || sum >= tar){
            if(sum == tar){
                ans.add(new ArrayList<>(li));
            }
            return;
        }

        //pick element and idx same for duplicate
        li.add(nums[idx]);
        subseq(li, idx, sum+nums[idx], nums);

        li.remove(li.size()-1);

        subseq(li, idx+1, sum, nums);
    }
}