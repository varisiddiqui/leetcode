class Solution {
    public int maxScore(int[] nums) {
        HashMap<String, Integer> dp = new HashMap<>();
        return maxSc(nums, new boolean[nums.length], 1, dp);
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int maxSc(int nums[], boolean vis[], int op, HashMap<String, Integer> dp) {
        int max = 0;

        StringBuilder str = new StringBuilder();
        for (boolean b : vis)
            str.append(String.valueOf(b));

        String s = str.toString();

        if(dp.containsKey(s)) return dp.get(s);

        for (int i = 0; i < nums.length - 1; i++) {
            if (vis[i] == true)
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (vis[j] == true)
                    continue;

               
                vis[i] = true;
                vis[j] = true;

                max = Math.max(max, gcd(nums[i], nums[j]) * op + maxSc(nums, vis, op + 1, dp));
                vis[i] = false;
                vis[j] = false;
            }
        }

        dp.put(s, max);

        return max;
    }
}