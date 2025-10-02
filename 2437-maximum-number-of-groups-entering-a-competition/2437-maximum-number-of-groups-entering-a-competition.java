class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        return (int)((Math.sqrt(1 + 8L * n) - 1) / 2);
    }
}
