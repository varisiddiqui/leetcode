class Solution {
    public boolean canChange(String start, String target) {
         int n = start.length();
        int i = 0, j = 0;

        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;

            if (i == n || j == n) return i == n && j == n;

            char a = start.charAt(i);
            char b = target.charAt(j);
            if (a != b) return false;

            if (a == 'L' && i < j) return false; // L can only move left
            if (a == 'R' && i > j) return false; // R can only move right

            i++;
            j++;
        }
        return true;
    }
}