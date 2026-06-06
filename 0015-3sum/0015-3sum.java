class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        HashSet<List<Integer>> ans = new HashSet<>();

        for(int i=0; i<n; i++){
            HashSet<Integer> seen = new HashSet<>();

            

            for(int j=i+1; j<n; j++){
                int target = -(nums[i]+nums[j]);
                if(seen.contains(target)){
                    List<Integer> li = new ArrayList<>(Arrays.asList(nums[i], nums[j], target));
                    Collections.sort(li);
                    ans.add(li);
                }

                seen.add(nums[j]);
            }
        }
        

       

        return new ArrayList<>(ans);

        

        

       
        
    }
}