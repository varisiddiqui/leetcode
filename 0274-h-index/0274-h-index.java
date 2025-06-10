class Solution {
    public int hIndex(int[] citations) {
        int max = 0;
        Arrays.sort(citations);
        int n = citations.length;

        for(int i=0; i<n; i++){
            int atleast = n-i;
            if(citations[i] <= atleast){
                max = Math.max(max, citations[i]);
            }
        }
        int count=0;
        for(int i=n-1; i>=0; i--){
            if(citations[i] > count) count++;
            else break;
        }
        return Math.max(max, count);
    }
}