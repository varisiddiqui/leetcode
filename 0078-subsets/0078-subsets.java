class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        ans.add(al);
        for(int i=0; i<nums.length; i++){
            int size = ans.size();
            for(int j=0; j<size; j++){
                ArrayList<Integer> newSubset = new ArrayList<>(ans.get(j));
                newSubset.add(nums[i]);
                ans.add(newSubset);
            }
        }
        return ans;


    }
}