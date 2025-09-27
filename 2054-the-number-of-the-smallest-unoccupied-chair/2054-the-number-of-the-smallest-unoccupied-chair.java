class Solution {
    public int smallestChair(int[][] times, int tf) {
        int n = times.length;

        Comparator<int[]> cmp = (a, b) -> {
            return a[0]-b[0];
        };

        int arr[][] = new int[n][3];
        for(int i=0; i<n; i++){
            arr[i][0] = times[i][0];
            arr[i][1] = times[i][1];
            arr[i][2] = i; //person no
        }

        Arrays.sort(arr, cmp);

        //cmp1 for position 
        

        //cmp2 for end time
        Comparator<int[]> cmp2 = (a, b) -> {
            return a[0]-b[0];
        };

        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<int[]> located = new PriorityQueue<>(cmp2);

        for(int i=0; i<n; i++){
            free.add(i);
        }


        for(int i=0; i<n; i++){

            while(!located.isEmpty() && located.peek()[0] <= arr[i][0]){
                free.add(located.remove()[1]);
            }

            if(arr[i][2] == tf) return free.peek();
        

            located.add(new int[]{arr[i][1], free.remove()});


        }


       
        

        return 0;

    }
}