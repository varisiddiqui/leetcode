class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean vis[][] = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            if(board[i][0] == 'O'){
                q.add(new int[]{i,0});
                board[i][0]='0';
                vis[i][0]=true;
            }

            if(board[i][n-1] == 'O'){
                q.add(new int[]{i, n-1});
                board[i][n-1]='0';
                vis[i][n-1]=true;
            }
        }

        for(int j=1; j<n-1; j++){
            if(board[0][j] == 'O'){
                q.add(new int[]{0, j});
                board[0][j]='0';
                vis[0][j]=true;
            }

            if(board[m-1][j] == 'O'){
                q.add(new int[]{m-1, j});
                board[m-1][j]='0';
                vis[m-1][j]=true;
            }
        }

        int d[][] = {{0,-1}, {-1,0}, {0,1}, {1,0}};

        while(!q.isEmpty()){
            int curr[] = q.remove();

            for(int i=0; i<4; i++){
                int row = d[i][0]+curr[0];
                int col = d[i][1]+curr[1];

                if(row>=0 && row<m && col>=0 && col<n && !vis[row][col] && board[row][col]=='O'){
                    board[row][col]='0';
                    vis[row][col]=true;
                    q.add(new int[]{row, col});
                }

            }

        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == '0'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O') board[i][j]='X';
                
            }
        }
        




    }

    

}