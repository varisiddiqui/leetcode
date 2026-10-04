class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        long sum = 0;

        for(int num: cardPoints) sum += num;

        if(n==k) return (int)sum;

        long window_sum=0;

        for(int i=0; i<n-k; i++) window_sum += cardPoints[i];

        long ans=0;

        ans = Math.max(ans, sum-window_sum);

        int left=0;
        int right = n-k-1;

        while(right<n){
            window_sum -= cardPoints[left];
            left++;
            right++;
            if(right >= n) break;

            window_sum += cardPoints[right];

            ans = Math.max(ans, sum-window_sum);
        }

        return (int)ans;
    }
}