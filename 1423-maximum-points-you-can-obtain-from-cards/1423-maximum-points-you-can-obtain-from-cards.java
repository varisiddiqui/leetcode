class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l=0, r=0;
        int sum=0;

        int total = 0;
        for(int num: cardPoints) total += num;

        while(r<n-k){
            sum += cardPoints[r];
            r++;
        }
       // System.out.println(sum);

        int minSum=Integer.MAX_VALUE;
        minSum = Math.min(minSum, sum);

        while(r<n){
            sum -= cardPoints[l];
           // System.out.println(sum);
            l++;
            sum += cardPoints[r];
            r++;
            minSum = Math.min(minSum, sum);
            //System.out.println(sum);
        }

        return total - minSum;
        
    }
}