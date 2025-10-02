class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int count=2, k=1;
        for(int i=1; i<=n; i=i+count){
            if(i>1){
                count++;
                k++;
            }        
        }
        return k;
    }
}