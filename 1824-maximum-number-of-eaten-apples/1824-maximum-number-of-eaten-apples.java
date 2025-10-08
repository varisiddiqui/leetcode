class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int n = days.length;
        Comparator<int[]> cmp = (a, b) -> {
            return a[1] - b[1];
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);
        int time = 1;
        int ans = 0;
        int curr[] = new int[2];

        for (int i = 0; i < n; i++) {

            if (apples[i] != 0)
                pq.add(new int[] { apples[i], i + days[i] });

            while (!pq.isEmpty() && pq.peek()[1] < time) {
                //System.out.println(pq.peek()[0] + " " + pq.peek()[1]);
                pq.remove();
            }

            if (!pq.isEmpty()) {
                curr = pq.remove();
                //System.out.println(curr[0] + " " + curr[1]);
            } else
                curr = new int[2];

            if (curr[0] > 0)
            ans += 1;

                if (curr[0] - 1 > 0) {
                    curr[0] -= 1;
                    pq.add(curr);
                }

            time++;
        }

        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[1] < time) {
                //System.out.println(pq.peek()[0] + " " + pq.peek()[1]);
                pq.remove();
            }

            if (!pq.isEmpty()) {
                curr = pq.remove();
                //System.out.println(curr[0] + " " + curr[1]);
            } else
                curr = new int[2];

            if (curr[0] > 0)
            ans += 1;

                if (curr[0] - 1 > 0) {
                    curr[0] -= 1;
                    pq.add(curr);
                }

            time++;
        }

        return ans;
    }
}