class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> cut = new ArrayList<>();
        cut.add(0);
        for(int i=0; i<cuts.length; i++)
        cut.add(cuts[i]);
        cut.add(n);
        Collections.sort(cut);

        int sz=cut.size();

        int dp[][] = new int[sz][sz];

        for(int i=sz-1; i>=0; i--){
            for(int j=i+1; j<sz; j++){
                int min=Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    int c1 = dp[i][k];
                    int c2 = dp[k][j];
                    int c3 = cut.get(j)-cut.get(i);
                    min = Math.min(min, c1+c2+c3);
                }
                if(min != Integer.MAX_VALUE)
                dp[i][j]=min;
                
            }
        }
       
        return  dp[0][sz-1];
    }
}