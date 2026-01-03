class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
          int[] a = new int[n];
        int[] maxAllowed = new int[n];
        
        for (int i = 0; i < n; i++) {
            maxAllowed[i] = Integer.MAX_VALUE;
        }
        
        for (int[] r : restrictions) {
            maxAllowed[r[0]] = r[1];
        }
        
        a[0] = 0;
        for (int i = 1; i < n; i++) {
            a[i] = Math.min(a[i - 1] + diff[i - 1], maxAllowed[i]);
        }
         for (int i = 1; i < n; i++) {
            a[i] = Math.min(a[i], a[i - 1] + diff[i - 1]);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            a[i] = Math.min(a[i], a[i + 1] + diff[i]);
        }
        
       
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
        }
        
        return max;

    }
}