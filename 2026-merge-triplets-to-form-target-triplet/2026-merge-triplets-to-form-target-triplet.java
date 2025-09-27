class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;

       
        if(n == 1 && Arrays.equals(triplets[0], target)){
            return true;
        }
        //Set<Integer> set = new HashSet<>();
       int c1=0,c2=0,c3=0;

        for(int j=0; j<n; j++){
           
            if(triplets[j][0]>target[0] || triplets[j][1]> target[1] || triplets[j][2]> target[2] ){
                continue;
            }
            else{
                if(c1 == 0 && triplets[j][0] == target[0]) c1=1;
            if(c2 == 0 && triplets[j][1] == target[1]) c2=1;
            if(c3 == 0 && triplets[j][2] == target[2]) c3=1;
            }
        }

        

       


        if(c1==1 && c2==1 && c3==1) return true;
        return false;

        
    }
}