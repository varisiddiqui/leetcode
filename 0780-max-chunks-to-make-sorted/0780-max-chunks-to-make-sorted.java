class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int maxChunks=0;

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(i);
            int count=0;
            for(int j=0; j<=i; j++){
                if(set.contains(arr[j]))
                count++;
            }
            if(count == i+1)
            maxChunks++;
        }
        return maxChunks;
    }
}