class Solution {
    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    public long minimumTime(int[] d, int[] r) {
        long d1 = d[0], d2 = d[1];
        long r1 = r[0], r2 = r[1];

        long lcm = (r1 / gcd(r1, r2)) * r2;

        long low = 0, high = (long) 2e18;

        while (low < high) {
            long T = (low + high) >>> 1;

            long a = T - (T / r1);                    // drone1 usable hours
            long b = T - (T / r2);                    // drone2 usable hours
            long common = T - (T / r1 + T / r2 - T / lcm);

            if (a >= d1 && b >= d2 && a + b - common >= d1 + d2)
                high = T;      // feasible, try smaller time
            else
                low = T + 1;   // not feasible, increase time
        }

        return low;
    }
}
