class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String common=strs[0];
        for(int i=1; i<n; i++){
            int minL = Math.min(common.length(), strs[i].length());
            int j=0;
            for(j=0; j<minL; j++){
                if(strs[i].charAt(j) != common.charAt(j)) {
                    break;
                }
            }
            common = strs[i].substring(0, j);
        }
        return common;
    }
}