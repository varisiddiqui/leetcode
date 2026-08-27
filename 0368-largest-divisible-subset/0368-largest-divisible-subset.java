class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n];
        int map[] = new int[n];
        Arrays.fill(map, -1);

        Arrays.fill(dp, 1);

        int max=0;
        int last=0;

        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[i]%nums[j] == 0 && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    map[i] = j;
                }
            }

            if(max < dp[i]){
                max = dp[i];
                last = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        int i=last;

        while(i != -1){
            ans.add(0, nums[i]);
            i = map[i];
        }

        return ans;

       
    }
}