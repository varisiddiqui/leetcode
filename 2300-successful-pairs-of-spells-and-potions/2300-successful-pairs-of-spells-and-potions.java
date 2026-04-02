class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int pair[] = new int[n];
        

        for(int i=0; i<n; i++){
            int idx = pairs(spells[i], potions, success);
            if(idx == m) continue;
            else{
                pair[i]=m-idx;
            }             
        }
        return pair;
    }

    public int pairs(int spell, int potions[], long success){
        int low = 0;
        int high = potions.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if((long)potions[mid]*(long)spell >= success){
                high = mid-1;
            }
            else low = mid+1;
        }

        return low;

    }
}