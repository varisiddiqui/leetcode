class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        boolean vis[][] = new boolean[r][c];

       for(int i=0; i<r; i++){
        if(!vis[i][0] && board[i][0]=='O'){
            dfs(i, 0, board, vis);
        }
        if(!vis[i][c-1] && board[i][c-1]=='O'){
            dfs(i, c-1, board, vis);
        }
       }

       for(int j=0; j<c; j++){
        if(!vis[0][j] && board[0][j]=='O'){
            dfs(0, j, board, vis);
        }
        if(!vis[r-1][j] && board[r-1][j]=='O'){
            dfs(r-1, j, board, vis);
        }
       }

       for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            if(!vis[i][j] && board[i][j]=='O'){
                board[i][j]='X';
            }
        }
       }
       


    }

    public void dfs(int i, int j, char board[][], boolean vis[][]){
        int r = board.length;
        int c = board[0].length;
        vis[i][j]=true;


        if(i+1<r && board[i+1][j]=='O' && !vis[i+1][j]){
            dfs(i+1, j, board, vis);
        }

        if(i-1>=0 && board[i-1][j]=='O' && !vis[i-1][j]){
            dfs(i-1, j, board, vis);
        }

        if(j+1<c && board[i][j+1]=='O' && !vis[i][j+1]){
            dfs(i, j+1, board, vis);
        }

        if(j-1>=0 && board[i][j-1]=='O' && !vis[i][j-1]){
            dfs(i, j-1, board, vis);
        }


    }
}