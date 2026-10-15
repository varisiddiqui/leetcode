class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;

       @SuppressWarnings("unchecked")
       HashMap<Long, Integer>[] diff = new HashMap[n];

        Arrays.setAll(diff, (i) -> new HashMap<>());

        int ans=0;

        for(int i=1; i<n; i++){
           
                long d = (long)nums[i] - (long)nums[i-1];

                int cntAns = diff[i-1].getOrDefault(d, 0);

                ans += cntAns;

                diff[i].put(d, diff[i].getOrDefault(d, 0)+cntAns+1); 
            
        }

        return ans;

    }
}