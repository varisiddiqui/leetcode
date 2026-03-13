class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int l=0, r=0;
        int n = fruits.length;
        int max=0;

        while(r<n){
            if(hm.size() > 2){
                if(hm.get(fruits[l])-1 == 0) hm.remove(fruits[l]);
                else
                hm.put(fruits[l], hm.getOrDefault(fruits[l], 0) - 1);
                l++;
            }
            hm.put(fruits[r], hm.getOrDefault(fruits[r], 0)+1);

            if(hm.size() <= 2){
                max = Math.max(max, r-l+1);
            }

           
            r++;
        }
        return max;
    }
}