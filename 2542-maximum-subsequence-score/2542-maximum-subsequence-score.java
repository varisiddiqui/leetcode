class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(b[1], a[1]);
        };

        int arr[][] = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }

        Arrays.sort(arr, cmp);

        long sumK=0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<k; i++){
            sumK += arr[i][0];
            pq.add(arr[i][0]);
        }

        long res = sumK*arr[k-1][1];

        for(int i=k; i<n; i++){
            sumK += (arr[i][0] - pq.poll());
            pq.add(arr[i][0]);

            res = Math.max(res, sumK*arr[i][1]);
            

        }
        return res;
    }
}