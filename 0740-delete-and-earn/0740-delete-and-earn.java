class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int num: nums) hm.put(num, hm.getOrDefault(num, 0) + 1);

        int arr[] = new int[hm.size()];

        int dp[] = new int[hm.size()];

        Arrays.fill(dp, -1);

        int k=0;

        for(int key: hm.keySet()) arr[k++]=key;

        Arrays.sort(arr);

        return max(0, arr, hm, dp);
    }

    public int max(int curr_idx, int arr[], Map<Integer, Integer> hm, int dp[]){
        if(curr_idx >= arr.length) return 0;

        if(dp[curr_idx] != -1) return dp[curr_idx];

        int take=arr[curr_idx] * hm.get(arr[curr_idx]);

        if(curr_idx+1 < arr.length && arr[curr_idx+1] != arr[curr_idx]+1){
            take += max(curr_idx+1, arr, hm, dp);
        }
        else if(curr_idx+1 < arr.length && arr[curr_idx+1] == arr[curr_idx]+1){
            take += max(curr_idx+2, arr, hm, dp);
        }

        int skip = max(curr_idx+1, arr, hm, dp);

        return dp[curr_idx] =  Math.max(take, skip);

       
    }
}