class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int arr[][] = new int[n][3];//start,end,idx

        for(int i=0; i<n; i++){
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(a[0], b[0]);
        };

        Arrays.sort(arr, cmp);

        Comparator<int[]> cmp1 = (a, b) -> {
            if(a[0] != b[0])
            return Integer.compare(a[0], b[0]);//end, idx
            else return a[1]-b[1];
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp1);

        int time=0;
        int i=0;

        int ans[] = new int[n];
        int k=0;

        while(i<n){
            while(i<n && arr[i][0] <= time){
                pq.add(new int[]{arr[i][1], arr[i][2]});
                i++;
            }
            if(!pq.isEmpty()){
                int duration = pq.peek()[0];
                ans[k++] = pq.peek()[1];
                pq.poll();
                time += duration;
            }
            else time = arr[i][0];
        }
        
        while(!pq.isEmpty()){
            ans[k++] = pq.poll()[1]; 
        }

        return ans;
    }
}