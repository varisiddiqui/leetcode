class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int r=0;
        int lastSeen[] = new int[3];
        Arrays.fill(lastSeen, -1);

        int sum=0;

        while(r<n){
            char ch = s.charAt(r);
            lastSeen[ch-'a']=r;

            int min = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));

            if(min != -1){
                sum += min+1;
            }
            
            r++;

        }
        return sum;


    }
}