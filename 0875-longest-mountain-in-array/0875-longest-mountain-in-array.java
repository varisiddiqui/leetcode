class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if(n<3)
        return 0;

         int prefix[] = new int[n];
         Arrays.fill(prefix, 1);
         int suffix[] = new int[n];
         Arrays.fill(suffix, 1);

        //inc
         for(int i=1; i<n; i++){
            if(arr[i-1] < arr[i]){
                prefix[i] = prefix[i-1]+1;
            }
         }

         //inc back
         for(int i=n-2; i>=0; i--){
            if(arr[i] > arr[i+1]){
                suffix[i] = suffix[i+1]+1;
            }
         }

         int max=0;
         for(int i=1; i<n-1; i++){
            if(arr[i-1]<arr[i] && arr[i]>arr[i+1])
            max = Math.max(max, prefix[i-1]+suffix[i+1]);
         }

         if(max == 0)
         return max;
         else
         return max+1;
    }
}