class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
         int n = tops.length;
         int minSteps=Integer.MAX_VALUE;

         for(int i=1; i<=6; i++){
            int top=0;
            int bottom=0;
            int j;
            for(j=0; j<n; j++){
                if(tops[j] != i && bottoms[j] != i) break;
                else{
                    if(tops[j] == i && bottoms[j] == i){
                        continue;
                    }
                    else if(tops[j] == i) top++;
                    else bottom++;
                }
            }
          
            if(j==n)
            minSteps = Math.min(minSteps, Math.min(top, bottom));
         }
         return minSteps==Integer.MAX_VALUE? -1: minSteps;


    }
}