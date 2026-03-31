class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat[0].length-1;
        int n = mat.length;
        int m = mat[0].length;
 

        while(low <= high){
            int mid = low + (high-low)/2;
            int row = findMax(mat, n, mid);
            int left = -1;
            int right= -1;
            if(mid-1 >=0) left = mat[row][mid-1];
            if(mid+1 < m) right = mat[row][mid+1];

            if(mat[row][mid] > left && mat[row][mid]>right) return new int[]{row, mid};
            else if(mat[row][mid] < left){
                high = mid-1;
            }
            else low = mid+1;

        }
        return new int[]{};

    }

    public int findMax(int mat[][], int n, int mid){
        int max=-1;
        int maxIdx=-1;

        for(int i=0; i<n; i++){
            if(max < mat[i][mid]){
                max = mat[i][mid];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}