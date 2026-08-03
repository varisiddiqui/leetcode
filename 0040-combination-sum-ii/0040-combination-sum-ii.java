class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        subseq(candidates, 0, target, new ArrayList<>());
        return ans;
    }

    public void subseq(int nums[], int idx, int sum, List<Integer> li) {

        if (idx == nums.length || sum <= 0) {
            if (sum == 0)
                ans.add(new ArrayList<>(li));
            return;
        }

        HashSet<Integer> used = new HashSet<>();

        for (int i = idx; i < nums.length; i++) {

            if (used.contains(nums[i]))
                continue;
            used.add(nums[i]);

            li.add(nums[i]);
            subseq(nums, i + 1, sum - nums[i], li);
            li.remove(li.size() - 1);
        }

    }
}