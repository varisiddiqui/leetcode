class Solution {
    int ans=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<k; i++) hm.put(i, 0);

        ans(cookies, cookies.length-1, k, hm);

        return ans;
    }

    public void ans(int cookies[], int idx, int k, Map<Integer, Integer> hm){
        if(idx < 0){
            int max=0;
            for(int key: hm.keySet()){
                max= Math.max(max, hm.get(key));
            }

            ans = Math.min(ans, max);
            return;
        }

    

        for(int i=0; i<k; i++){
            if(ans < hm.get(i)+cookies[idx]) continue;
            hm.put(i, hm.get(i)+cookies[idx]);
            ans(cookies, idx-1, k, hm);
            hm.put(i, hm.get(i)-cookies[idx]);
        }
    }
}