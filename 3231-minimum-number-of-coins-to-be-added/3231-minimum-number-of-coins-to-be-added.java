class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
         int i=0, sum=0, j=0;
         int c=0;
         //if(coins[0] != 1) c++;
         

         while( sum<target){
            //System.out.println(i);
           if(i<coins.length && sum+1 >= coins[i]){
                sum += coins[i];
                i++;
           }
           else{
            sum += sum+1;
            c++;
           }

         }
         return c;







    }
}