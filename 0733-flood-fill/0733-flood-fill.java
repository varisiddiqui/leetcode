class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r = image.length;
        int c = image[0].length;
        int org = image[sr][sc];

        //boolean vis[][] = new boolean[r][c];
    
                dfs(org, image, sr, sc, color);
        
        
        return image;
    }

    public void dfs(int org, int image[][], int i, int j, int color){
       
   
        
        int r = image.length;
        int c = image[0].length;

        image[i][j]=color;
        if(i+1<r && image[i+1][j] == org&& image[i+1][j] != color){
            dfs(org, image, i+1, j, color);
        }

        if(i-1>=0 && image[i-1][j] == org && image[i-1][j] != color){
            dfs(org, image, i-1, j, color);
        }

        if(j+1<c && image[i][j+1] == org&& image[i][j+1] != color){
            dfs(org, image, i, j+1, color);
        }

        if(j-1>=0 && image[i][j-1]==org&& image[i][j-1] != color){
            dfs(org, image, i, j-1, color);
        }
    }
}