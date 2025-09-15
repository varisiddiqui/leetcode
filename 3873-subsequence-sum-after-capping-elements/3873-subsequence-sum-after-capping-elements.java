class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        //ans array
        boolean ans[] = new boolean[n];

        boolean dp[][] = new boolean[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = true;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                //valid
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        //now we know all possibilities

        for (int l = 0; l < n; l++) {
            int arr[] = new int[n]; //new array
            int x = l + 1;//capping element
            for (int j = 0; j < n; j++) {
                arr[j] = Math.min(x, nums[j]);
            }

            int start=0;
            int end = arr.length-1;
            int idx=n-1;
            while(start<end){
                int mid = (start+end)/2;
                if(arr[mid] >= x){
                    end=mid;
                }
                else{
                    start = mid+1;
                }

            } 
            
            idx = start;
            //for dp element at = idx+1
            if(arr[idx] != x){
                ans[l]=dp[n][k];
                continue;
            }
            
            

            
            int sum=0;
            for(int i=idx ; i<n; i++){
                if(dp[idx][k]){
                    ans[l]=true;
                    break;
                }
                sum += x;
                if(sum <= k){
                    if(dp[idx][k-sum]){
                        ans[l]=true;
                        break;
                    }                    
                }
                else
                break;
                
                
            }

        }
        return ans;

    }

}