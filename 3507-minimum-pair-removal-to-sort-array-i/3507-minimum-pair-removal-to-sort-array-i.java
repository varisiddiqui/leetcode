class Solution {
    public int minimumPairRemoval(int[] nums) {
        
        List<Integer> li = new ArrayList<>();
        for(int num: nums) li.add(num);
        int op=0;
    

        for(int i=0; i<li.size()-1; i++){

            if(li.get(i) > li.get(i+1)){
                int j=0;
                int smallestSum=Integer.MAX_VALUE;
                int smallestIdx=-1;

                while(j<li.size()-1){
                    if(li.get(j)+li.get(j+1) < smallestSum){
                        smallestSum = li.get(j)+li.get(j+1);
                        smallestIdx=j;
                    }
                    j++;
                }

                li.remove(smallestIdx);
                li.remove(smallestIdx);
                li.add(smallestIdx, smallestSum);
                i=-1;
                op++;

            }
        }
        return op;
    }
}