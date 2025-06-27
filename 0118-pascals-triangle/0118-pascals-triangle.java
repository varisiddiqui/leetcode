class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();
                
        ArrayList<Integer> zero = new ArrayList<>();
        zero.add(1);
        dp.add(zero); //initialize zero
        if(numRows==1) return dp;
        zero = new ArrayList<>();
        zero.add(1);
        zero.add(1);
        dp.add(zero); //initialize one
        if(numRows == 2) return dp;
        

        for(int i=2; i<numRows; i++){
            List<Integer> prev = dp.get(i-1);
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j=0; j<prev.size()-1; j++){
                curr.add(prev.get(j)+prev.get(j+1));
            }
            curr.add(1);
            dp.add(curr);
        }
        return dp;


        //
    }
}