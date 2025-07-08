class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n = intervals.length;

        List<List<Integer>> res = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        if(n==1){
            return intervals;
        }

        for(int i=1; i<n; i++){          
            //next
            int nextSt = intervals[i][0];
            int nextEnd = intervals[i][1];

            if(start <= nextSt && nextSt <= end){
                end = Math.max(end, nextEnd);
                if(i==n-1){
                    res.add(new ArrayList<>(Arrays.asList(start, end)));
                }
            }
            else {
                res.add(new ArrayList<>(Arrays.asList(start, end)));
                start = intervals[i][0];
                end = intervals[i][1];
                if(i==n-1){
                    res.add(new ArrayList<>(Arrays.asList(start, end)));
                }
            }
     
        }
        //System.out.println(res);
        int ans[][] = new int[res.size()][2];
        for(int i=0; i<res.size(); i++){
            ans[i][0]=res.get(i).get(0);
            ans[i][1]=res.get(i).get(1);
        }
        return ans;
        
    }
}