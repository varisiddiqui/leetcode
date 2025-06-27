class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long prefixRow[]= new long[grid.length];
        long prefixCol[] = new long[grid[0].length];

        //for row
        for(int i=0; i<grid.length; i++){
            long sum=0;
            for(int j=0; j<grid[i].length; j++){
                sum += grid[i][j];
            }
            if(i==0)
            prefixRow[i] = sum;
            else
            prefixRow[i] = prefixRow[i-1]+sum;
        }

        //for col
        for(int i=0; i<grid[0].length; i++){
            long sum=0;
            for(int j=0; j<grid.length; j++){
                sum += grid[j][i];
            }
            if(i==0)
            prefixCol[i] = sum;
            else
            prefixCol[i] = prefixCol[i-1]+sum;
        }

        boolean res = false;
        for(int i=0; i<grid.length; i++){
            if((prefixRow[i]) == (prefixRow[grid.length-1]-prefixRow[i]))
            return true;
        }

        for(int i=0; i<grid[0].length-1; i++){
            if((prefixCol[i]) == (prefixCol[grid[0].length-1]-prefixCol[i]))
            return true;
        }
        return false;
    }
}