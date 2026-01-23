class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int pos=0;
        int n = nums.length;

        while(pos <n && nums[pos]<0) pos++;

        List<List<Integer>> li = new ArrayList<>();

        if(pos == n ) return li;

        Set<List<Integer>> set = new HashSet<>();

        while(pos < n){
            int left = 0;
            int right = n-1;
            int req = -nums[pos];
            int sum=0;
            while(left < right){
    
                if(left == pos) left++;
                if(right == pos) right--;
                if(left >= right) break;
                sum = nums[left]+nums[right];

                if(sum == req) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[pos], nums[left], nums[right]));
                    Collections.sort(list);
                    set.add(list);
                    left++;
                    right--;
                   
                }
                else if(sum < req){
                    left++;
                }
                else right--;

            }
            pos++;

        }

        
        for(List<Integer> list : set) li.add(list);

        return li;
    }
}