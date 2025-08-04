class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        //base case
        if(n == 1){
            res.add(nums[0]);
            return res;
        }

        int dp[] = new int[n];
        int hash[] = new int[n];

        Arrays.fill(dp, 1);

        int max=0;
        int pos=0;
        for(int i=1; i<n; i++){
            hash[i]=i;
            for(int j=i-1; j>=0; j--){
                if(nums[i]%nums[j] == 0){
                    if(dp[i] < dp[j]+1){
                        dp[i]=dp[j]+1;
                        hash[i]=j;
                        if(max < dp[i]){
                            max = dp[i];
                            pos=i;
                        }
                    }
                    
                }
            }
        }
       
       res.add(nums[pos]);

       while(hash[pos] != pos){
        pos = hash[pos];
        res.add(nums[pos]);
       }

    Collections.reverse(res);
        return res;

        
        
    }
}