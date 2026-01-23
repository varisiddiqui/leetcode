class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        for(int layer=0; layer<n/2; layer++){
            
            for(int j=layer; j<n-1-layer; j++)
            {
                List<int[]> li = new ArrayList<>();
                li.add(new int[]{layer, j});
                int row = layer;
                int col = j;
                for(int k=0; k<3; k++){
                    int dupRow = row;
                    int dupCol = col;
                    col = (n-1)-dupRow;
                    row = dupCol;
                    li.add(new int[]{row, col});
                }

                int temp = matrix[li.get(3)[0]][li.get(3)[1]];

                for(int k=3; k>=1; k--){
                    matrix[li.get(k)[0]][li.get(k)[1]] = matrix[li.get(k-1)[0]][li.get(k-1)[1]];
                }

                matrix[li.get(0)[0]][li.get(0)[1]] = temp;

                
                
            }
            
        }
    }
}