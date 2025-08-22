class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int leftCol=grid[0].length-1;
        int rightCol = 0;

        int topRow = n-1;
        int bottomRow = 0;
       
        int ent = -1;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    ent = 1;
                    topRow = Math.min(topRow, i);
                    bottomRow = Math.max(bottomRow, i);
                    leftCol = Math.min(leftCol, j);
                    rightCol = Math.max(rightCol, j);
                }
            }
        }

        if(ent == -1) return 0;

        return (rightCol-leftCol+1)*(bottomRow-topRow+1); 
    }
}