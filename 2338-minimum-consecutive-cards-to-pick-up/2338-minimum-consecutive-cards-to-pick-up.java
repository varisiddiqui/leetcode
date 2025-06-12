class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        int n = cards.length;
        int min = n+1;
        for(int i=0; i<n; i++){
            hm.putIfAbsent(cards[i], new ArrayList<Integer>());
            ArrayList<Integer> a = hm.get(cards[i]);
            if(a.size()>0){
                min = Math.min((i-a.get(a.size()-1)+1), min);
            }
            a.add(i);
        }
        
        
        if(min==n+1) return -1;
        return min;
    }
}