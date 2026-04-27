class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(i==0 || i==n-1){
                ans.add(nums[i]);
                continue;
            }
            boolean isValid = true;
            for(int j=0; j<i; j++){
                if(nums[j] >= nums[i]) {
                    isValid = false;
                    break;
                }
            }
            if(!isValid){
                isValid = true;
                for(int j=i+1; j<n; j++){
                    if(nums[j]>=nums[i]){
                        isValid = false;
                        break;
                    }
                }
            }
            if(isValid) ans.add(nums[i]);
        }
        return ans;
    }
}