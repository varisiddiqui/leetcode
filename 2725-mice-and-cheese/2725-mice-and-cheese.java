class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int arr[][] = new int[n][3];
        //insert 2-d along with idx
        for(int i=0; i<n; i++){
            arr[i][0] = reward1[i];
            arr[i][1] = reward2[i];
            arr[i][2] = reward1[i]-reward2[i];
        }

        Comparator<int[]> cmp1 = (a, b) -> {
            if(b[2] == a[2])
            return Integer.compare(a[1], b[1]);
            else
            return Integer.compare(b[2], a[2]);
        };

        Arrays.sort(arr, cmp1);

        int pts=0;

        for(int i=0; i<n; i++){
            if(i<k){
                pts += arr[i][0];
            }
            else{
                pts += arr[i][1];
            }
        }

        

        
        return pts;
    }
}