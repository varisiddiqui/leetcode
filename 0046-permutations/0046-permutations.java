class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        perm(new ArrayList<>(), new boolean[nums.length], nums);
        return ans;
    }

    public void perm(List<Integer> li, boolean used[], int nums[]){
        if(li.size() == nums.length){
            ans.add(new ArrayList<>(li));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!used[i]){
                li.add(nums[i]);
                used[i] = true;

                perm(li, used, nums);

                li.remove(li.size()-1);
                used[i] = false;
            }
            
        }
    }
}