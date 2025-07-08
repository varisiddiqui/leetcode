class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n=timePoints.size();
        int res[]= new int[n];

        for(int i=0; i<n; i++){
            String s = timePoints.get(i);
            int hr = Integer.parseInt(s.substring(0,2));
            int min = Integer.parseInt(s.substring(3,5));

            if(hr == 0 && min == 0){
                res[i]= 1440;
            }
            else
            res[i] = hr*60 + min;
        }
        Arrays.sort(res);
     
        int min = 1500;
        for(int i=0; i<n-1; i++){
            int diff = res[i+1]-res[i];
            min = Math.min(min, diff);
        }

        
    
        return Math.min(min, (1440-res[n-1]+res[0]));
    }
}