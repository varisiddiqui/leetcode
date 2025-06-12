class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = cards.length;
        int min = n+1;
        for(int i=0; i<n; i++){
            if(hm.containsKey(cards[i])){
                min = Math.min((i-(hm.get(cards[i])) + 1), min);
            }
            hm.put(cards[i], i);
        }
        
        
        if(min==n+1) return -1;
        return min;
    }
}