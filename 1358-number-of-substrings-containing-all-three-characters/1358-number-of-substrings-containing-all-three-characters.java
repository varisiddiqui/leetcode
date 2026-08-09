class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int i=0;

        int lastseen[] = new int[3];
        Arrays.fill(lastseen, -1);

        int no=0;

        while(i<n){
             char ch = s.charAt(i);
             lastseen[ch-'a'] = i;

             int min = Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2]));

             if(min != -1){
                no += min+1;
             }
             i++;
        }

        return no;
    }
}