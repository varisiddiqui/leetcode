class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int i=0;
        int j=0;
        int n = arrivals.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        

        Set<Integer> set = new HashSet<>();

        while(i<w){
            if(hm.containsKey(arrivals[i])){
                if(hm.get(arrivals[i])+1 > m){
                    set.add(i);
                }
                else
                hm.put(arrivals[i], hm.get(arrivals[i])+1);
            }
            else
            hm.put(arrivals[i], 1);
            i++;
        }
        //System.out.println(hm);
        i=1;
        j=w;

        while(j<n){
            if(!set.contains(i-1)){
                if(hm.get(arrivals[i-1])-1 <= 0){
                    hm.remove(arrivals[i-1]);
                }
                else{
                    hm.put(arrivals[i-1], hm.get(arrivals[i-1])-1);
                }
            }
            
                    if(hm.containsKey(arrivals[j])){
                if(hm.get(arrivals[j])+1 > m){
                    set.add(j);
                }
                else
                hm.put(arrivals[j], hm.get(arrivals[j])+1);
            }
            else
            hm.put(arrivals[j], 1);
            

            i++;
            j++;


        }

        return set.size();


        

    }
}