class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int maxChunks=0;
        int indexSum=0;
        int realSum=0;

       
        for(int i=0; i<n; i++){
            indexSum += i;
            realSum += arr[i];
            if(indexSum == realSum)
            maxChunks++;
           
        }
        return maxChunks;
    }
}