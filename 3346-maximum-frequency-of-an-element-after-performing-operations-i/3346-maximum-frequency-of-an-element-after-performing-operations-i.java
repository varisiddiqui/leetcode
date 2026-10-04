class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        int n = nums.length;

        int min = nums[0] - k;
        int max = nums[n - 1] + k;

        int offset = -min;
        int size = max - min + 2;

        int[] diff = new int[size];

        // Range of values each element can reach
        for (int num : nums) {
            int l = num - k + offset;
            int r = num + k + offset;

            diff[l]++;
            diff[r + 1]--;
        }

        // Frequency of original values
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int coverage = 0;
        int ans = 1;

        for (int i = 0; i < size - 1; i++) {

            coverage += diff[i];

            int x = i - offset;

            // If x exists, some elements are already x.
            // Otherwise same = 0.
            int same = freq.getOrDefault(x, 0);

            int canChange = coverage - same;

            int current = same + Math.min(numOperations, canChange);

            ans = Math.max(ans, current);
        }

        return ans;
    }
}