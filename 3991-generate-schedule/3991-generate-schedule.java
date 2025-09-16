class Solution {

    boolean conflict(List<Integer> a, List<Integer> b){
        return (a.get(0) == b.get(0) || a.get(0) == b.get(1) || a.get(1) == b.get(0) || a.get(1) == b.get(1));
    }

    public int[][] generateSchedule(int n) {
        if(n<5) 
        return new int[][]{};

        List<List<Integer>> matches = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i != j){
                    matches.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        for(int attempt=0; attempt<10; attempt++){
            Collections.shuffle(matches);
            boolean ok = true;
            for(int i=1; i<matches.size(); i++){
                if(conflict(matches.get(i), matches.get(i-1))){
                    int j=i+1;
                    while(j<matches.size() && conflict(matches.get(j), matches.get(i-1)))
                    j++;

                    if(j == matches.size()){
                        ok = false;
                        break;
                    }

                    Collections.swap(matches, i, j);
                }
            }

            if(ok)
            {
                int ans[][] = new int[matches.size()][2];
                for(int i=0; i<matches.size(); i++){
                    List<Integer> li = matches.get(i);
                    ans[i][0] = li.get(0);
                    ans[i][1] = li.get(1);
                }
                return ans;
            }
        }
        return new int[][]{};
    }
}