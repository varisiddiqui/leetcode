class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        Comparator<int[]> cmp = (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            else if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            else
                return Integer.compare(a[2], b[2]);
        };

        int arr[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];//start time
            arr[i][1] = tasks[i][1]; //processing time
            arr[i][2] = i;
        }

        Arrays.sort(arr, cmp);

        Comparator<int[]> cmp1 = (a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            else
                return Integer.compare(a[2], b[2]);
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp1);

        int i = 0;
        int time = 1;
        boolean enter = false;
        int k=0;
        int order[]  = new int[n];

        while (i < n) {
            while (i < n && arr[i][0] <= time) {
                pq.add(new int[] { arr[i][0], arr[i][1], arr[i][2] });
                i++;
                
            }
            

            if(!pq.isEmpty()){
                order[k++] = pq.peek()[2];
                time += pq.peek()[1];
                pq.remove();
            }
            else{
           
                time = arr[i][0];
            
            
            }
        }

        while(!pq.isEmpty()){
            order[k++]=pq.remove()[2];
        }
        return order;

    }
}