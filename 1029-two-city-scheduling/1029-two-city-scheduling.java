class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;

        

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(b[0]-b[1], a[0]-a[1]);  //descending 
        };

        Arrays.sort(costs, cmp);

        int sum=0;

        for(int i=0; i<n; i++){
           

            if(i<n/2) sum += costs[i][1];
            else sum += costs[i][0];
        }
        return sum;


    }
}