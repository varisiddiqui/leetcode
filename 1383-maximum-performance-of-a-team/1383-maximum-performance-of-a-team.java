class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
         

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(b[1], a[1]);
        };

        int arr[][] = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = speed[i];
            arr[i][1] = efficiency[i];
        }

        Arrays.sort(arr, cmp);

        long sumK=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int MOD = 1_000_000_007;
        long res=0;

        for(int i=0; i<n; i++){
            sumK += arr[i][0];
            
            if(pq.size() >= k) sumK -= pq.poll();

            pq.add(arr[i][0]);

            res = Math.max(res, (sumK*arr[i][1]));
            
            
        }

        return (int)(res%MOD);
    }
}