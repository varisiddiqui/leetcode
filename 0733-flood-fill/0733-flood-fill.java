class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int original = image[sr][sc];

        Queue<int[]> q = new LinkedList<>();

        boolean vis[][] = new boolean[m][n];

        q.add(new int[]{sr, sc});
        vis[sr][sc] = true;

        image[sr][sc]=color;

        int d[][] = {{-1,0}, {0,-1}, {1,0}, {0, 1}};

        while(!q.isEmpty()){
            int sz = q.size();

            for(int i=0; i<sz; i++){
                int curr[] = q.remove();
                int row = curr[0];
                int col = curr[1];

                for(int j=0; j<4; j++){
                    int dr = d[j][0]+row;
                    int dc = d[j][1]+col;
                    if(dr >=0 && dr<m && dc>=0 && dc<n && !vis[dr][dc] && image[dr][dc]==original){
                        vis[dr][dc]=true;
                        image[dr][dc]=color;
                        q.add(new int[]{dr, dc});
                    }
                }
            }

        }

        return image;


    }
}