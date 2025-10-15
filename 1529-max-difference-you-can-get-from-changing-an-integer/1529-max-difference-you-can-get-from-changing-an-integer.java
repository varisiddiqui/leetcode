class Solution {
    public int maxDiff(int num) {
        List<Integer> li = new ArrayList<>();
        int dup = num;
        while(dup>0){
            int d = dup%10;
            li.add(0, d);
            dup /= 10;
        }
        
        while(li.get(0)==0){
            li.remove(0);
        }
        int l = li.size();
        int target2=li.get(0);
        int target1=li.get(0);
        if(target1==1){
            int k=0;
            while(k<l &&(li.get(k) ==1 ||li.get(k)==0)){
                k++;
            }
            target1 = (k<l)?li.get(k): 1;

        }
        if(target2==9){
            int k=0;
            while(k<l &&(li.get(k) ==9)){
                k++;
            }
            target2 = (k<l)?li.get(k): 9;

        }
    
       
        long min=0;
        long max=0;
        for(int i=0; i<l; i++){
            if(li.get(i)==target1){
                if(li.get(0)!=1)
                min += 1L*(long)Math.pow(10, l-i-1);
                else if(target1 != 1) min += 0;
                else if(target1 == 1){
                    min += 1L*(long)Math.pow(10, l-i-1);
                }

                
            }
            else 
            min += li.get(i)*1L*(long)Math.pow(10, l-i-1);

            if(li.get(i)==target2){
                max += 9L*(long)Math.pow(10, l-i-1);
            }
            else 
            max += li.get(i)*1L*(long)Math.pow(10, l-i-1);

            
        }
        return (int)(max-min);
    }
}