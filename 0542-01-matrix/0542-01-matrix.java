class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        int res[][] = new int[r][c];
        boolean vis[][] = new boolean[r][c];
        bfs(mat, res, vis);
        return res;
    }

    public void bfs(int mat[][], int res[][], boolean vis[][]){
        int r = mat.length;
        int c = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(mat[i][j] == 0){
                    vis[i][j]=true;
                    q.add(new int[]{i, j, 0});
                }
                
            }
        }


        while(!q.isEmpty()){
            int arr[] = q.remove();
            int i=arr[0];
            int j=arr[1];
            int dis=arr[2];
            res[i][j]=dis;

            if(i+1<r && mat[i+1][j] == 1 && !vis[i+1][j]){
                vis[i+1][j]=true;
                q.add(new int[]{i+1, j, dis+1});
            }
            if(i-1>=0 && mat[i-1][j] == 1 && !vis[i-1][j]){
                vis[i-1][j]=true;
                q.add(new int[]{i-1, j, dis+1});
            }
            if(j+1<c && mat[i][j+1] == 1 && !vis[i][j+1]){
                vis[i][j+1]=true;
                q.add(new int[]{i, j+1, dis+1});
            }
            if(j-1>=0 && mat[i][j-1] == 1 && !vis[i][j-1]){
                vis[i][j-1]=true;
                q.add(new int[]{i, j-1, dis+1});
            }
        }



    }
}