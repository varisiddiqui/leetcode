class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        long cost=0;
        int n = s.length();

        int zero=0;
        int one=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(s.charAt(i) == '0') zero++;
                else one++;
            }
        }

       // System.out.println(zero+" "+one);

        //case-1
        if(swapCost<=flipCost*2 && zero>0 && one>0){
            int min = Math.min(zero, one); //within swap with 0 and 1
            cost += min*1L*swapCost;
            zero -= min;
            one -= min;

            

            if((zero>0 || one>0) && (crossCost+swapCost)<=flipCost*2){
                if(zero > 1){
                    int minZ = zero/2;
             
                    cost += minZ*1L*(crossCost+swapCost);
                    zero -= minZ*2;
                
                }
                
                if(one>1){
                 
                    int minO = one/2;

                    cost += minO*1L*(crossCost+swapCost);
                    one -= 2*minO;
                
                }


            }

            if(zero>0 || one>0){
                cost += (zero+one)*1L*flipCost;
                zero=0;
                one=0;
            }
            System.out.println(cost);
        }

       
        
         if((crossCost+swapCost) <= 2*flipCost && (zero>0 || one>0)){
                 if(zero > 1){
                    int minZ = zero/2;
             
                    cost += minZ*1L*(crossCost+swapCost);
                    zero -= minZ*2;
                
                }
                
                if(one>1){
                 
                    int minO = one/2;

                    cost += minO*1L*(crossCost+swapCost);
                    one -= 2*minO;
                
                }

                if(zero>0 || one>0){
                cost += (zero+one)*1L*flipCost;
                zero=0;
                one=0;
                }
                


        }

        if(zero>0 || one>0){
            cost += (zero+one)*1L*flipCost;
        }

        return cost;
    }
}