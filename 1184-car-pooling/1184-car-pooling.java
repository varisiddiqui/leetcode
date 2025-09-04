class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max=0;
        int n = trips.length;

        int l=10001;
        int r=0;
        for(int i=0; i<n; i++){
            l = Math.min(l, trips[i][1]);
            r = Math.max(r, trips[i][2]);
        }
        
        for(int i=l; i<=r; i++){
            int tot=0;
            int hour=i;
            for(int j=0; j<n; j++){
                int x1 = trips[j][1];
                int y1 = trips[j][2];
                if(hour>=x1 && hour<y1)
                tot += trips[j][0];               
            }

            max = Math.max(max, tot);
        }

        //System.out.println(max);

        return max<=capacity;


    }
}