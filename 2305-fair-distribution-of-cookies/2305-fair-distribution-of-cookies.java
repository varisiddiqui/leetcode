class Solution {
    int ans=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int hm[] = new int[8];
        

        ans(cookies, cookies.length-1, k, hm);

        return ans;
    }

    public void ans(int cookies[], int idx, int k, int hm[]){
        if(idx < 0){
            int max=0;
            for(int key: hm){
                max= Math.max(max, key);
            }

            ans = Math.min(ans, max);
            return;
        }

    

        for(int i=0; i<k; i++){
            if(ans < hm[i]+cookies[idx]) continue;
            hm[i] =hm[i]+cookies[idx];
            ans(cookies, idx-1, k, hm);
            hm[i] = hm[i]-cookies[idx];
        }
    }
}