class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        Comparator<int[]> cmp = (a, b) -> {
            if(a[0] != b[0]){
                return b[0]-a[0];
            }
            else if(a[1] != b[1]){
                return b[1]-a[1];
            }
            else{
                return a[2]-b[2];
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

        int prevBig[] = new int[n];
        Arrays.fill(prevBig, -1);

        for(int i=n-1; i>=1; i--){
            for(int j=i-1; j>=0; j--){
                if(arr[j]>arr[i]){
                    prevBig[i]=j;
                    break;
                }
            }
        }


        for(int i=0; i<n; i++){
            if(prevBig[i] != -1){
                pq.add(new int[]{prevBig[i], arr[i], i});
            }
        }
        if(pq.isEmpty()) return arr;
        int a[] = pq.peek();

        int toSwap = a[0];
        int fromSwap = a[2];

        int temp = arr[toSwap];
        arr[toSwap] = arr[fromSwap];
        arr[fromSwap] = temp;

        return arr;



    }
}