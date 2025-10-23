class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] count = new int[n + 1];

         for (int x : arr) {
            count[Math.min(x, n)]++;
        }

        int curr = 0;
        for (int i = 1; i <= n; i++) {
            if (count[i] > 0) {
                curr = Math.min(curr + count[i], i);
            }
        }
        return curr;

    }
}