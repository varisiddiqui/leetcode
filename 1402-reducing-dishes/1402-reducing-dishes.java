class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int n = satisfaction.length;
        int ans = 0;

        

        

        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            int t=1;
            for (int j = i; j < n; j++) {
                sum += (t * satisfaction[j]);
                ans = Math.max(ans, sum);
                t++;
            }
        }
        return ans;
    }
}