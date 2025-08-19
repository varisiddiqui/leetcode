class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;

       int f=-1;
    int p=-1;
       for(int i=n-1; i>=1; i--){
        if(arr[i-1]>arr[i]){
            int min = Integer.MIN_VALUE;
            p = i-1;
            for(int j=i; j<n; j++){
                if(arr[j]<arr[p] && min < arr[j]){
                    min = arr[j];
                    f=j;
                    
                }
            }
            if(f!=-1) break;
        }
       }

       if(f == -1)
       return arr;

       int temp = arr[f];
       arr[f] = arr[p];
       arr[p]=temp;



        return arr;



    }
}