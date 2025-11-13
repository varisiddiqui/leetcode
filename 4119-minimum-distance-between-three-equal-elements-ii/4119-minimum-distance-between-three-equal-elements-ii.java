class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int arr[][] = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(a[0], b[0]);
        };

        Arrays.sort(arr, cmp);

        int min = Integer.MAX_VALUE;
        boolean enter = false;

        for(int i=0; i<n; i++){
            if(i+2<n && arr[i][0] == arr[i+2][0]){
                min = Math.min(min, 2*Math.abs(arr[i+2][1] - arr[i][1]));
                enter = true;
            }
        }

        return (enter)?min:-1;
    }
}