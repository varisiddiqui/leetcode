class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max=0;
        int n = trips.length;

        int arr[] = new int[1001];

        for(int i=0; i<n; i++){
            int pick = trips[i][1];
            int drop = trips[i][2];
            int pass = trips[i][0];
            arr[pick] += pass;
            arr[drop] -= pass;
        }

        for(int i=0; i<1001; i++){
            max += arr[i];
            if(max>capacity)
            return false;
        }
        return true;

     
       

        


    }
}