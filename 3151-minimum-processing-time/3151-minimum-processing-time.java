class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        int max=-1;

        Collections.sort(processorTime);
        Collections.sort(tasks);

        int n = tasks.size();
        int j=0;
        for(int i=n-1; i>=0; i=i-4){
            max= Math.max(max, processorTime.get(j)+tasks.get(i));
            j++;
        }
        return max;
    }
}