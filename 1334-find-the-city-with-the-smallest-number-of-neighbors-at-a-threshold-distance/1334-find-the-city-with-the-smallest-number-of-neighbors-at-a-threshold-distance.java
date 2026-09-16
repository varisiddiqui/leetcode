class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];

        for(int i=0; i<n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        for(int i=0; i<n; i++) dist[i][i]=0;

        for(int edg[]: edges){
            dist[edg[0]][edg[1]] = edg[2];     
            dist[edg[1]][edg[0]] = edg[2];
        }
        

        for(int via=0; via<n; via++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][via] == Integer.MAX_VALUE || dist[via][j] == Integer.MAX_VALUE) continue;
                        dist[i][j] = Math.min(dist[i][j], dist[i][via]+dist[via][j]);
                    
                }
            }
        }

        int smallestCity=-1;

        int minReachable=n+1;

        for(int i=0; i<n; i++){
            int currReach=0;
            for(int j=0; j<n; j++){
                if(dist[i][j] <= distanceThreshold) currReach++;
            }
            if(currReach < minReachable){
                minReachable = currReach;
                smallestCity = i;
            }
            else if(currReach == minReachable) smallestCity = Math.max(smallestCity, i);
        }

        return smallestCity;

    }
}