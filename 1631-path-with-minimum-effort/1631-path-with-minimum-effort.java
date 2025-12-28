class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        int diff[][] = new int[r][c];
        for(int i=0; i<r; i++)
        Arrays.fill(diff[i], Integer.MAX_VALUE);
        diff[0][0] = 0;

        Comparator<int[]> cmp = (a, b) -> {
             return Integer.compare(a[0], b[0]);
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

        pq.add(new int[]{0, 0, 0});

        int dr[] = {0, 0, 1, -1};
        int dc[] = {1, -1, 0, 0};

        while(!pq.isEmpty()){
            int top[] = pq.remove();
            int i=top[1];
            int j=top[2];

            //means someone reached i,j at minimal diff than this so it will be in queue so we can't insert in this one because of greater efforts 
            if(top[0] > diff[i][j]) continue;

            

            for(int k=0; k<4; k++){
                int nr = i+dr[k];
                int nc = j+dc[k];

                if(nr>=0 && nr<r && nc>=0 && nc<c ){
                    int difference = Math.max(top[0],Math.abs(heights[nr][nc]-heights[i][j]));
                    if(diff[nr][nc] == Integer.MAX_VALUE){
                        diff[nr][nc] = difference;
                        pq.add(new int[]{difference, nr, nc});
                    }
                    else if(diff[nr][nc] > difference){
                        diff[nr][nc] = difference;
                        pq.add(new int[]{difference, nr, nc});
                    }
                }
            }

            }
            return diff[r-1][c-1];



        


    }
}