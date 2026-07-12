class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length; //2n

        int temp[][] = new int[n][3];

        for(int i=0; i<n; i++){
            temp[i][0] = i;//actual idx
            temp[i][1] = Math.min(costs[i][0], costs[i][1]); //min of both cities
            temp[i][2] = Math.abs(costs[i][0]-costs[i][1]); //diff of both to sort
        }

        Comparator<int[]> cmp = (a, b) -> {
            if(a[2] != b[2])
            return Integer.compare(b[2], a[2]);
            else return Integer.compare(a[1], b[1]);
        };

        Arrays.sort(temp, cmp);

        int sum=0;

        int a=0;
        int b=0;

        for(int i=0; i<n; i++){
            int idx = temp[i][0];
            
            if(costs[idx][0] < costs[idx][1] && a<n/2){
                sum += costs[idx][0];
                a++;
            }
            else if(costs[idx][0] > costs[idx][1] && b<n/2){
                sum += costs[idx][1];
                b++;
            }
            else {
                if(a<n/2) {
                    sum += costs[idx][0];
                    a++;
                }
                else{
                    sum += costs[idx][1];
                    b++;
                }
            }
        }

        return sum;
    }
}