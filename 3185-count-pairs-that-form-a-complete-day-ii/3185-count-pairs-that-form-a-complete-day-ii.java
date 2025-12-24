class Solution {
    public long countCompleteDayPairs(int[] hours) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = hours.length;

        long ans=0;
        hm.put(hours[0]%24, 1);
        for(int i=1; i<n; i++){
            int req = (hours[i]%24==0)?0:24-(hours[i]%24);
            int put = hours[i]%24;
            
            if(hm.containsKey(req)) ans = ans+hm.get(req);

            //System.out.println(req+" "+put+" "+ans);

            hm.put(put, hm.getOrDefault(put, 0) + 1);

        }
       // System.out.println(hm);
        return ans;
    }
}