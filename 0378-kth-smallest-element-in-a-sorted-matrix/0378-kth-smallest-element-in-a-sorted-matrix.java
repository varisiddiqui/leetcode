class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
               
                    pq.add(matrix[i][j]);
                
            }
            
        }
        int ans = -1;
        while(!pq.isEmpty() && k-->0){
            ans = pq.remove();

        }
        return ans;
        
        

    }
}