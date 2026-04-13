import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;

        double[][] arr = new double[n][2];

        // store quality and ratio
        for (int i = 0; i < n; i++) {
            arr[i][0] = quality[i];
            arr[i][1] = (double) wage[i] / quality[i];
        }

        // sort by ratio
        Arrays.sort(arr, (a, b) -> Double.compare(a[1], b[1]));

        // max heap for quality
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        double sum = 0;
        double ans = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            double q = arr[i][0];
            double ratio = arr[i][1];

            maxHeap.add(q);
            sum += q;

            if (maxHeap.size() > k) {
                sum -= maxHeap.poll(); // remove largest quality
            }

            if (maxHeap.size() == k) {
                ans = Math.min(ans, sum * ratio);
            }
        }

        return ans;
    }
}