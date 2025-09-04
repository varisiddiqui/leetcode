class Solution {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(a[0], b[0]);
        };

        Arrays.sort(meetings, cmp);
        int tot=meetings[0][0]-1;//for 1 to first day of meeting

        int prev = meetings[0][1];//1st meeting over

        for(int i=1; i<n; i++){
            if(prev < meetings[i][0]){
                tot += (meetings[i][0]-prev-1);
                prev = meetings[i][1];
            }
            else if(prev >= meetings[i][0]){ // coincided meeting
                prev = Math.max(prev, meetings[i][1]);
            } 
           
        }

        tot += days-prev;

        return tot;
    }
}