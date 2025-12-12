class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int countNeg=0;
        int r = matrix.length;
        int c = matrix[0].length;

        long sum=0;
        long min=Math.abs(matrix[0][0]);

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(matrix[i][j] < 0) countNeg++;
                min = Math.min(min, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        }

        return (countNeg%2==0)? sum: sum-2*min;

        
    }
}