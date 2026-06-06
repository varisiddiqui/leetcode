class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();

    

        
        for(int i=0; i<n; i++){
            if(nums[i]>0) break;
            int left=i+1; 
            int right = n-1;

            int target = -nums[i];

            while(left<right){
                if(nums[left]+nums[right] == target){
                    List<Integer> li = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    //Collections.sort(li);
                    set.add(li);
                    left++;
                    right--;

                }
                else if(nums[left]+nums[right] < target) left++;
                else right--;
            }

            
        }

        return new ArrayList<>(set);

        

        

       
        
    }
}