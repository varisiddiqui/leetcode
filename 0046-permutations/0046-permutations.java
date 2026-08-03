class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> li = new ArrayList<>();
        for(int num: nums) li.add(num);
        perm(li, 0, nums);
        return ans;
    }

    public void swap(List<Integer> li, int i, int j){
        int temp = li.get(i);
        li.set(i, li.get(j));
        li.set(j, temp);
    }

    public void perm(List<Integer>li, int idx, int nums[]){
        if(idx == nums.length){
            ans.add(new ArrayList<>(li));
            return;
        }

        for(int i=idx; i<nums.length; i++){
            swap(li, idx, i);

            perm(li, idx+1, nums);

            swap(li, idx, i);
        }
    }
}