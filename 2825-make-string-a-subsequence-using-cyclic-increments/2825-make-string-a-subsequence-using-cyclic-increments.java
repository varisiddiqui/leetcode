class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int i=0, j=0;

        while(i<n && j<m){
            int comp = (str1.charAt(i)+1)%123;
            if(comp == 0) comp = 97;
            if(str2.charAt(j) == str1.charAt(i) || str2.charAt(j) == (char)(comp)){
                i++;
                j++;
            }
            else i++;
        }
        return j==m;
    }
}