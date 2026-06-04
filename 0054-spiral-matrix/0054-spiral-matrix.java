class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> li = new ArrayList<>();

        int left=0;
        int right = n-1;

        int top=0;
        int bottom = m-1;

        while(true){
         
            for(int i=left; i<=right; i++){
                li.add(matrix[top][i]);
               // enter = true;
            }
            top++;

            if(top > bottom) break;

            for(int i=top; i<= bottom; i++){
                li.add(matrix[i][right]);
               // enter = true;
            }
            right--;

            if(left > right) break;

            for(int i=right; i>=left; i--){
                li.add(matrix[bottom][i]);
                //enter = true;
            }
            bottom--;
            if(top > bottom) break;

            for(int i=bottom; i>=top; i--){
                li.add(matrix[i][left]);
                //enter = true;
            }

            left++;
             if(left > right) break;
        
        }

        

        

        

           

            
        

        return li;
    }
}