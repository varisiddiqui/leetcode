class Solution {
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> li = new ArrayList<>();
        for(int num: nums){
            if(num >= 0) li.add(num);
        }

        List<Integer> dup = new ArrayList<>(li);

        int sz=li.size();
        for(int i=0; i<li.size(); i++){
            li.set(i, dup.get((i+k)%sz));
        }
        int it=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] >=0){
                nums[i]=li.get(it++);
            }
        }
        return nums;


    }
}