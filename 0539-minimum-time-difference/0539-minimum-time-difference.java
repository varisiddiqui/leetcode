class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n=timePoints.size();
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<n; i++){
            String s = timePoints.get(i);
            int hr = Integer.parseInt(s.substring(0,2));
            int min = Integer.parseInt(s.substring(3,5));

            if(hr == 0 && min == 0){
                res.add((24*60));
            }
            else
            res.add((hr*60) + min);
        }
        Collections.sort(res);
        System.out.println(res);
        int min = 1500;
        for(int i=0; i<n-1; i++){
            int diff = res.get(i+1)-res.get(i);
            min = Math.min(min, diff);
        }

        int diff = 1440-res.get(n-1);
        diff += res.get(0);
        min = Math.min(min, diff);
    
        return min;
    }
}