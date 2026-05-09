class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        int n = items.length;
        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(b[0], a[0]);
        };

        Arrays.sort(items, cmp);

        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> st = new Stack<>();

        long profit=0;

        long maxPr = 0;

        for(int i=0; i<k; i++){
            if(set.contains(items[i][1])){
                st.push(items[i][0]);
            }
            else 
            set.add(items[i][1]);

            profit += items[i][0];
        
        }

        maxPr = profit + (long)set.size()*1L*set.size();

        for(int i=k; i<n; i++){
            if(!set.contains(items[i][1]) && !st.isEmpty()){
                set.add(items[i][1]);
                profit -= st.pop();
                profit += items[i][0];

                maxPr = Math.max(maxPr, profit + (set.size())*1L*set.size());
            }
        }

        return maxPr;


    }
}