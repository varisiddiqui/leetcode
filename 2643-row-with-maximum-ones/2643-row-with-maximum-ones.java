class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length;

        int rowIdx=-1;
        int maxOcc=0;
        

        for(int i=0; i<n; i++){
            int occur = firstOcc(mat[i]);
            if(occur == -1) continue;
            else{
                if(occur > maxOcc){
                    maxOcc = occur;
                    rowIdx = i;
                }
            }
        }
        if(rowIdx == -1) return new int[]{0, 0};
        return new int[]{rowIdx, maxOcc};
    }

    public int firstOcc(int nums[]){
        Arrays.sort(nums);
        int n = nums.length;
        int low=0;
        int high=n-1;
        int ans=n+1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == 1){
                ans = n-mid;
                high = mid-1;
            }
            else low = mid+1;
        }

       // System.out.println(ans);

        return ans==n+1? -1: ans;
    }
}