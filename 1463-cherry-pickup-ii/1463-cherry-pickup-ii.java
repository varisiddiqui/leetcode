class Solution {
    public int cherryPickup(int[][] grid) {
        int m= grid.length;
        int n = grid[0].length;

        int dp[][][] = new int[m][n][n];

        //base case
        for(int j1=0; j1<n; j1++){
            for(int j2=0; j2<n; j2++){
                if(j1 == j2) dp[m-1][j1][j2] = grid[m-1][j1];
                else dp[m-1][j1][j2] = grid[m-1][j1]+grid[m-1][j2];
            }
        }

        for(int i=m-2; i>=0; i--){
            //for robot-1 col
            for(int j1=0; j1<n; j1++){
                //for robot-2 col
                for(int j2=0; j2<n; j2++){

                    int max=0; //it will contain the next row max choco pickup

                    //try all next row possibilities
                    for(int dj1=-1; dj1<=1; dj1++){ // for next row for robot-1
                        for(int dj2=-1; dj2<=1; dj2++){ // for 
                           
                            int nextJ1 = j1+dj1;
                            int nextJ2 = j2+dj2;

                             //base case
                             if(nextJ1<0 || nextJ2<0 || nextJ1>=n || nextJ2>=n) continue;

                            max = Math.max(max, dp[i+1][nextJ1][nextJ2]);
                        }
                    }

                    if(j1 == j2) dp[i][j1][j2] = grid[i][j1] + max;
                     else dp[i][j1][j2] = grid[i][j1]+grid[i][j2]+max;
                }

                
            }
        }

        return dp[0][0][n-1];
    }
}