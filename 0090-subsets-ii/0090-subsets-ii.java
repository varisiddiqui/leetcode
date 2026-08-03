class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subseq(new ArrayList<>(), 0, nums);
        return ans;
    }

    public void subseq(List<Integer> li, int idx, int nums[]){
       
            ans.add(new ArrayList<>(li));
            

        for(int i=idx; i<nums.length; i++){
            if(i>idx && nums[i] == nums[i-1]) continue;

            li.add(nums[i]);
            subseq(li, i+1, nums);
            li.remove(li.size()-1);  
        }
    }
}