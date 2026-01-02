class Solution {
    public int findTheCity(int n, int[][] edges, int th) {

        int dist[][] = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        for(int i=0; i<n; i++) dist[i][i]=0;

        for(int k=0; k<edges.length; k++){
            int src = edges[k][0];
            int des = edges[k][1];
            int wt = edges[k][2];
            dist[src][des] = wt;
            dist[des][src] = wt;
        }

        for(int via=0; via<n; via++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][via] != Integer.MAX_VALUE && dist[via][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][via]+dist[via][j]);
                    }
                }
            }
        }

        //List<int[]> li = new ArrayList<>();
        int minCity=101;
        int maxNode=-1;

        for(int i=0; i<n; i++){
            int countReachable=0;
            for(int j=0; j<n; j++){
                if(dist[i][j] <= th){
                    countReachable++;
                }
            }
            if(countReachable > 0 && minCity>=countReachable){
                minCity = Math.min(minCity, countReachable);
                maxNode = Math.max(maxNode, i);
            }
        }

        

        return maxNode;
    }
}