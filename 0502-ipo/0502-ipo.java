class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int arr[][] = new int[n][2];

        k= Math.min(k, n);

        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(a[0], b[0]);
        };

        Arrays.sort(arr, cmp);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      
            int i=0;

        while (k > 0) {
            while (i<n && arr[i][0] <= w) {
                //System.out.println(arr[i][0]);
                pq.add(arr[i][1]);
                i++;
            }

            if(pq.isEmpty()) return w;


            
            w += pq.remove();
            k--;
        }

        while(k>0 && !pq.isEmpty()){
            w += pq.remove();
            k--;
        }

        return w;

    }
}