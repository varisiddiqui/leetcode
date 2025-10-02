class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int limit=1,i=2;
        int gp=0;
        while(limit<=n){
            limit = i*(i+1)/2;
            i++;
            gp++;
        }
       
        return gp;
    }
}