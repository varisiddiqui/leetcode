class Solution {
    public int minimumK(int[] nums) {
        int left = 1, right = 100000;
        int ans = right;

        while (left <= right) {
            int k = left + (right - left) / 2;

            long op = 0;

            for (int x : nums) {
                op += (x + k - 1) / k; 
                if (op > (long) k * k) break;
            }

            if (op <= (long) k * k) {
                ans = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }
        return ans;
    }
}
