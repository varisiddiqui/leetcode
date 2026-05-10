class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        
        long temp[] = new long[n*(n+1)/2];
        int k=0;

        int mod = 1_000_000_007;

        for(int i=0; i<n; i++){
            long sum=0;
            for(int j=i; j<n; j++){
                sum += nums[j];
                 temp[k++] = sum;
            }
           
        }
        Arrays.sort(temp);

        long res=0;
        for(int i=left-1; i<=right-1; i++) res += temp[i];

        return (int)(res%mod);
    }
}