class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1; i<=num2; i++){
            List<Integer> li = new ArrayList<>();
            int dup=i;
            while(dup>0){
                int d = dup%10;
                li.add(d);
                dup /= 10;
            }
            for(int j=1; j<li.size()-1; j++){
                if( (li.get(j)>li.get(j-1) && li.get(j)>li.get(j+1) || (li.get(j)<li.get(j-1) && li.get(j)<li.get(j+1)) )) count++;
            }
        }
        return count;
    }
}