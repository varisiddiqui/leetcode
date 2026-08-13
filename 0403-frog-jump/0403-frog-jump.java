class Solution {
    public boolean canCross(int[] stones) {
        int last = stones[stones.length-1];
        if(stones[1] != 1) return false;

       HashMap<Integer, Set<Integer>> dp  = new HashMap<>();
       dp.put(0, new HashSet<>());
      
        dp.put(1, new HashSet<>());
        dp.get(1).add(1); // to get at 1 we just have 1 unit;
       //dp[i] = units required to reach here

        HashSet<Integer> set = new HashSet<>();
        for(int pos: stones) set.add(pos);

        for(int i=1; i<last+1; i++){
            if(!set.contains(i)) continue;
            if(!dp.containsKey(i)) continue;
            Set<Integer> currUnit = dp.get(i);
            for(Integer k: currUnit){
        
                if(i+k-1 > i && i+k-1 < last+1 && set.contains(i+k-1)) {
                    if(dp.get(i+k-1) == null) dp.put(i+k-1, new HashSet<>());
                    dp.get(i+k-1).add(k-1);
                }
                if(i+k < last+1 ){
                    if(dp.get(i+k) == null) dp.put(i+k,new HashSet<>());
                    dp.get(i+k).add(k);
                }
                if(i+k+1 < last+1 ){
                    if(dp.get(i+k+1) == null) dp.put(i+k+1, new HashSet<>());
                    dp.get(i+k+1).add(k+1);
                }
            }
            
        }

        return dp.get(last) != null;
    }
    
}