class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(a[2], b[2]);
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

        pq.add(new int[]{0, 0, 0});

        int d[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        int minEffort[][] = new int[m][n];

        for(int i=0; i<m; i++) Arrays.fill(minEffort[i], Integer.MAX_VALUE);
        minEffort[0][0]=0;
      

    

        while(!pq.isEmpty()){
            int top[] = pq.remove();

            int row = top[0];
            int col = top[1];
            int effort = top[2];

            if(effort > minEffort[row][col]) continue;

            if(row == m-1 && col == n-1) break;

            for(int j=0; j<4; j++){
                int dr = row+d[j][0];
                int dc = col+d[j][1];

                if(dr>=0 && dr<m && dc>=0 && dc<n){
                    if(Math.max(effort, Math.abs(heights[row][col]-heights[dr][dc])) < minEffort[dr][dc]){
                        minEffort[dr][dc] = Math.max(effort, Math.abs(heights[row][col]-heights[dr][dc]));
                        pq.add(new int[]{dr, dc, minEffort[dr][dc]});
                    }
                }
            }
            

        }

        return minEffort[m-1][n-1];



    }
}