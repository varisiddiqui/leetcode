class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int nums2[][] = new int[n][2];

        Comparator<int[]> cmp = (a, b) -> {
            return a[0]-b[0];
        };

        for(int i=0; i<n; i++){
            nums2[i][0]=nums[i];
            nums2[i][1]=i;
        }
        Arrays.sort(nums2, cmp);

        
        int i=0;
        int j=n-1;

        while(i<n && j>=0 && (nums2[i][0]+nums2[j][0]) != target){
            if(nums2[i][0]+nums2[j][0]<target) i++;
            else j--;
        }

        

        return new int[]{nums2[i][1], nums2[j][1]};
    }
}