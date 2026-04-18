class Solution {
    public int minTaps(int n, int[] ranges) {
        
        int rightEnd[] = new int[n+1];

        for(int i=0; i<n+1; i++){
            int left = Math.max(0, i-ranges[i]);
            int right = Math.min(n+1, i+ranges[i]);

            rightEnd[left] = Math.max(rightEnd[left], right);
        }

        int taps=0;
        int maxEnd=0;
        int currEnd=0;

        for(int i=0; i<n+1; i++){
            if(i>maxEnd){
                return -1;
            }
         
                if(i>currEnd){
                    taps++;
                    currEnd = maxEnd;
                }
            
            maxEnd = Math.max(maxEnd, rightEnd[i]);
        }
        return taps;
        
    }
}