class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Comparator<int[]> cmp = (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        };

        Arrays.sort(intervals, cmp);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(ans.size()==0 || ans.get(ans.size()-1).get(1) < intervals[i][0]){
                ans.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
            }
            else{
                int end = Math.max(ans.get(ans.size()-1).get(1), intervals[i][1]);
                ans.get(ans.size()-1).set(1, end);
            }
        }

        int res[][] = new int[ans.size()][2];
        for(int i=0; i<ans.size(); i++){
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }
        return res;

    }
}