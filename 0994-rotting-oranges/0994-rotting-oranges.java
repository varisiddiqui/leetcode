class Solution {
    public int orangesRotting(int[][] graph) {
        int r = graph.length;
        int c = graph[0].length;

        //boolean vis[][] = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
        int freshCount=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(graph[i][j] == 2) 
                q.add(new int[]{i, j, 0});
                else if(graph[i][j] == 1) freshCount++;
            }
        }

        int count=0;

        count = bfs(q, graph, freshCount);

       

        return count;
        
    }

    public int bfs(Queue<int[]> q, int graph[][], int freshCount){
        int r = graph.length;
        int c = graph[0].length;
        int max=0;
        int fresh=0;

        while(!q.isEmpty()){
            int arr[] = q.remove();

            int i=arr[0];
            int j=arr[1];
            
            max = Math.max(max, arr[2]);

            if(i+1<r && graph[i+1][j] == 1){
                graph[i+1][j]=2;
                q.add(new int[]{i+1, j, arr[2]+1});
                fresh++;
            }

            if(i-1>=0 && graph[i-1][j] == 1){
                graph[i-1][j]=2;
                q.add(new int[]{i-1, j, arr[2]+1});
                fresh++;
            }

            if(j+1<c && graph[i][j+1] == 1){
                graph[i][j+1]=2;
                q.add(new int[]{i, j+1, arr[2]+1});
                fresh++;
            }

            if(j-1>=0 && graph[i][j-1]==1){
                graph[i][j-1] = 2;
                q.add(new int[]{i, j-1, arr[2]+1});
                fresh++;
            }


        }

        return (fresh == freshCount)? max: -1;
    }
}