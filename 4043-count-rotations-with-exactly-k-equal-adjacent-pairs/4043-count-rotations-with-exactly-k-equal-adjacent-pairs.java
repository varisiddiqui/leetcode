class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        int ans=0;

        for(int i=0; i<n; i++){
            String st = s.substring(0,i+1);
            String end = s.substring(i+1, n);

            String con = end+st;
            int cnt=0;
            for(int j=0; j<con.length()-1; j++){
                if(con.charAt(j) == con.charAt(j+1)) cnt++;
            }
            if(cnt == k) ans++;
        }

        return ans;

        
    }
}