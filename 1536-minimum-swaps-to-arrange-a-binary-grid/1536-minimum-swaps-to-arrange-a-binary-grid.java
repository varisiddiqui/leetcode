class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int count[] = new int[n];

        for(int i=0; i<n; i++){
            for(int j=n-1; j>=0; j--){
                if(grid[i][j] == 0) count[i]++;
                else break;
            }
        }


        int swap=0;
        
        for(int i=0; i<n-1; i++){
            boolean found = false;
            for(int j=i; j<n; j++){

                if(count[j] >= n-1-i){
                    //System.out.println(n-i-1+" " +count[j]);
                    found = true;

                    if(j == i){
                        found = true;
                    
                    }

                    else{
                        for(int k=j; k>i; k--){
                            int temp = count[k];
                            count[k] = count[k-1];
                            count[k-1] = temp;

                            swap++;
                        }
                    }

                    break;
                }


            }

            if(!found) return -1;
        }

        return swap;

    }
}