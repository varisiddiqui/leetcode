class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int i = s.indexOf(c);
        int j = -1;
        for(int k=0; k<n; k++){
            if(s.charAt(k) == c && k!=i){
                j=k;
                break;
            }
        }
        

        int it=0;
        int dist[] = new int[n];
        if(j<0){
                while(it<n){
                    dist[it] = Math.abs(i-it);
                    it++;
                }
                //System.out.println(j);     
        }

        while(it<n && j>=0){
            if(it<i){
                dist[it] = Math.abs(it-i);
                it++;
            }
            else if(it>=i && it<=j ){
                dist[it] = Math.min(Math.abs(it-i), Math.abs(it-j));
                it++;
            }
            else if(it>j){
                i=j;
                j++;
                while(j<n && s.charAt(j) != c){
                    j++;
                }
                if(j==n) break;

            }
        }
        while(it<n){
            dist[it] = Math.abs(it-i);
            it++;
        }
        
        return dist;
    }
}