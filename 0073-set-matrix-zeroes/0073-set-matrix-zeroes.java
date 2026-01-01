class Solution {
    public void setZeroes(int[][] matrix) {
        /*Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();*/

        int row[] = new int[matrix.length];
        int col[] = new int[matrix[0].length];


        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(row[i]==1 || col[j]==1) matrix[i][j]=0;
            }
        }
    }
}