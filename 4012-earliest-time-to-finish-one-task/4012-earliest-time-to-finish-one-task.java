class Solution {
    public int earliestTime(int[][] tasks) {
        int n = tasks.length;
        int min= Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(min, tasks[i][0]+tasks[i][1]);
        }
        return min;
    }
}