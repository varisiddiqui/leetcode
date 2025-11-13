class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hm.putIfAbsent(nums[i], new ArrayList<>());
            hm.get(nums[i]).add(i);
        }
        int min = Integer.MAX_VALUE;
        boolean enter = false;
        for(Integer key: hm.keySet()){
            List<Integer> li = hm.get(key);
            for(int i=0; i<li.size(); i++){
                if(i+2<li.size()){
                    int diff = 2*Math.abs(li.get(i+2)-li.get(i));
                    min = Math.min(min, diff);
                    enter = true;
                }
                else break;
            }
        }
        return (enter)?min:-1;
    }
}