class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;

    
        HashMap<Long, Integer> diff[] = new HashMap[n];

        Arrays.setAll(diff, (i) -> new HashMap<>());

        int ans=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                long d = (long)nums[i] - (long)nums[j];

                int cntAns = diff[j].getOrDefault(d, 0);

                ans += cntAns;

                diff[i].put(d, diff[i].getOrDefault(d, 0)+cntAns+1); 
            }
        }

        return ans;
    }
}