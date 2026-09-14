class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        int ans=0;
        int cnt=0;

        for(int i=0; i<n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)) cnt++;
        }

        

        StringBuilder str = new StringBuilder(s);

        for(int i=0; i<n; i++){
            char first = str.charAt(0);
            char last = str.charAt(n-1);

            if(first == str.charAt(1)) cnt--;

            if(first == last) cnt++;

            if(cnt == k) ans++;

            str.deleteCharAt(0);
            str.append(first);
        }

        return ans;

        
    }
}