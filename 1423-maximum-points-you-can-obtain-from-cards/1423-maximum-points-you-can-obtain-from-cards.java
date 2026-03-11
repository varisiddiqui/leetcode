class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

              
        int sum=0;
        for(int i=0; i<k; i++) sum += cardPoints[i];

        int maxSum=0;
        maxSum = Math.max(maxSum, sum);
        int r=n-1;

        for(int i=k-1; i>=0; i--){
            sum -= cardPoints[i];
            sum += cardPoints[r--];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;


    }
}