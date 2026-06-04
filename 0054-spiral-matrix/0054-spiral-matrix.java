class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean vis[][] = new boolean[m][n];
        int i=0, j=0;

        List<Integer> li = new ArrayList<>();
        li.add(matrix[0][0]);
        vis[0][0]=true;

        while(true){

            boolean enter=false;

            while(i<m && j+1<n && !vis[i][j+1]){ //top
                li.add(matrix[i][j+1]);
                vis[i][j+1]=true;
                j++;
                enter = true;
                
            }

            while(i+1<m && j<n && !vis[i+1][j]){ //right
                li.add(matrix[i+1][j]);
                 vis[i+1][j]=true;
                i++;
                enter = true;
               
            }

            while(i<m && j-1>=0 && !vis[i][j-1]){ //bottom
                li.add(matrix[i][j-1]);
                vis[i][j-1]=true;
                j--;
                 enter = true;
                 
            }

            while(i-1>=0 && j<n && !vis[i-1][j]){ //left
                li.add(matrix[i-1][j]);
                vis[i-1][j]=true;
                i--;
                 enter = true;
                 
            }

            //System.out.println(i+" "+j);

            if(!enter) break;

            
        }

        return li;
    }
}