class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        Set<List<Integer>> ans = new HashSet<>();

        for(int i=0; i<n; i++){

            for(int j=i+1; j<n; j++){
                int left = j+1; 
                int right = n-1;

                long tar = (long)(target)-nums[i]-nums[j];

                while(left < right){
                     long sum = (long) nums[left] + nums[right];
                    if(sum == tar){
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));

                        left++;
                        right--;

                       while(left<right && nums[left]==nums[left-1]) left++;

                       while(left<right && nums[right]==nums[right+1]) right--;
                    }
                    else if(sum< tar){
                        left++;
                    }
                    else right--;
                }
            }
        }

        return new ArrayList<>(ans);
    }
}