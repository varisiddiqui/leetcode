class Solution {
    public int orangesRotting(int[][] graph) {
        int r = graph.length;
        int c = graph[0].length;

        //boolean vis[][] = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(graph[i][j] == 2) 
                q.add(new int[]{i, j, 0});
            }
        }

        int count=0;

        count = bfs(q, graph);

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(graph[i][j] == 1) return -1;
                
            }
        }

        return count;
        
    }

    public int bfs(Queue<int[]> q, int graph[][]){
        int r = graph.length;
        int c = graph[0].length;
        int max=0;

        while(!q.isEmpty()){
            int arr[] = q.remove();

            int i=arr[0];
            int j=arr[1];
            
            max = Math.max(max, arr[2]);

            if(i+1<r && graph[i+1][j] == 1){
                graph[i+1][j]=2;
                q.add(new int[]{i+1, j, arr[2]+1});
            }

            if(i-1>=0 && graph[i-1][j] == 1){
                graph[i-1][j]=2;
                q.add(new int[]{i-1, j, arr[2]+1});
            }

            if(j+1<c && graph[i][j+1] == 1){
                graph[i][j+1]=2;
                q.add(new int[]{i, j+1, arr[2]+1});
            }

            if(j-1>=0 && graph[i][j-1]==1){
                graph[i][j-1] = 2;
                q.add(new int[]{i, j-1, arr[2]+1});
            }


        }

        return max;
    }
}