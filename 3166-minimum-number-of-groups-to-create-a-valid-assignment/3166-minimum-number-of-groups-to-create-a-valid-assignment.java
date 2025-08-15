class Solution {
    public int minGroupsForValidAssignment(int[] balls) {
        Map<Integer, Integer> hm = new HashMap<>();
        int n = balls.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            hm.put(balls[i], hm.getOrDefault(balls[i], 0) + 1);

        }

        for (Integer key : hm.keySet())
            min = Math.min(min, hm.get(key));
               

        int box = 0;
        int size = hm.size();
    
        for (int k = min; k >= 1; k--) {
            
            if (check(k, hm)) {
                min=k;
                break;
            } 
        }
    

    

    System.out.println(min);

    

    for(Integer key:hm.keySet())
    {
        int s = hm.get(key);
        int rem = s % (min + 1);
        box += s / (min + 1);

        if (rem > 0)
            box++;
    }

    return box;

    }

    public boolean check(int k, Map<Integer, Integer> hm) {
        for (Integer key : hm.keySet()) {
            int sz = hm.get(key);
            boolean possible = false;

            // Try all possible x from largest to smallest
            for (int x = sz / (k + 1); x >= 0; x--) {
                int rem = sz - x * (k + 1);

                // Check if remainder can be perfectly packed into k-sized groups
                if (rem == 0 || rem % k == 0) {
                    possible = true;
                    break; // Found a valid grouping
                }
            }

            if (!possible)
                return false; // No x worked
        }
        return true;

    }
}