import java.util.*;

class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        
       
        Set<Integer> uniquePoints = new TreeSet<>();

        for (int[] interval : intervals) {
            int s = interval[0];
            int e = interval[1];

            start.put(s, start.getOrDefault(s, 0) + 1);
            end.put(e, end.getOrDefault(e, 0) + 1);

            uniquePoints.add(s);
            uniquePoints.add(e);
        }

        long overlap = 0;
        long pairs = 0;

        
        for (int i : uniquePoints) {
           
            if (start.containsKey(i)) {
                long k = start.get(i);
                pairs += k * overlap;
              
                pairs += k * (k - 1) / 2;
               
                overlap += k;
            }

           
            if (end.containsKey(i)) {
                overlap -= end.get(i);
            }
        }

        return pairs;
    }
}