class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;

        int toLeave = n/3;
        int sum=0;

        for(int i=n-2; i>=toLeave; i=i-2){
            sum += piles[i];

        }

        return sum;
    }
}