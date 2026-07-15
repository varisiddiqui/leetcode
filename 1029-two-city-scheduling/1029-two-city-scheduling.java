class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;

        int temp[][] = new int[n][2];
        
        for(int i=0; i<n; i++){
            temp[i][0] = i; //idx
            temp[i][1] = costs[i][0]-costs[i][1]; //A-B
        }

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(b[1], a[1]);  //descending 
        };

        Arrays.sort(temp, cmp);

        int sum=0;

        for(int i=0; i<n; i++){
            int idx = temp[i][0];

            if(i<n/2) sum += costs[idx][1];
            else sum += costs[idx][0];
        }
        return sum;


    }
}