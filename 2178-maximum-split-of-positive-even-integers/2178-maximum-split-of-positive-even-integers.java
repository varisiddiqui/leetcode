class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum % 2 != 0) return new ArrayList<>();
        ArrayList<Long> ar =  new ArrayList<>();
        long i=1;

        while((finalSum-2*i) > 2*i){
            ar.add(2*i);
            finalSum -= 2*i;
            i++;
        }
        if(finalSum>0) ar.add(finalSum);
        return ar;
       
    }
}