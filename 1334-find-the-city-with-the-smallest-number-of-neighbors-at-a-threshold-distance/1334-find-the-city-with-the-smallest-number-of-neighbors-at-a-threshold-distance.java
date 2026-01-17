class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int graph[][] = new int[n][n];
    

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                if(i != j)
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        
     

        for(int i=0; i<edges.length; i++){
            int src = edges[i][0];
            int des = edges[i][1];
            int wt = edges[i][2];

            graph[src][des] = wt;
            graph[des][src] = wt;
        }

        for(int via=0; via<n; via++){
            for(int i=0; i<n; i++){
                if(graph[i][via] == Integer.MAX_VALUE) continue;
                for(int j=0; j<n; j++){
                    if(graph[via][j] == Integer.MAX_VALUE) continue;
                    graph[i][j] = Math.min(graph[i][j], (graph[i][via]+graph[via][j]));
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) 
            System.out.println(graph[i][j]+" ");
            System.out.println();
        }

        int max=n+1;
        int city=-1;
        for(int i=0; i<n; i++){//src
            int reachable=0;
            for(int j=0; j<n; j++){//des
                if(graph[i][j] <= distanceThreshold){
                    reachable++;
                }
            }
            if(max >= reachable){
                max = reachable;
                city = Math.max(city, i);
            }
        }
        return city;

        
    }
}