class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean vis[][] = new boolean[n][n];

        int prv=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
               
                if(isConnected[i][j]==1 && !vis[i][j]){
                    vis[i][j]=true;
                    vis[j][i]=true;
                    dfs(j, vis, isConnected);
                    prv++;
                }
            }
        }
        return prv;

    }

    public void dfs(int i, boolean vis[][], int isConnected[][]){
        for(int j=0; j<vis.length; j++){
            if(isConnected[i][j]==1 && !vis[i][j]){
                vis[i][j]=true;
                vis[j][i]=true;
                dfs(j, vis, isConnected);
            }
        }
    }


}