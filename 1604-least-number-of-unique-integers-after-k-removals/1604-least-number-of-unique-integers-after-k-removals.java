class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> tm = new HashMap<>();
        for(int i=0; i<n; i++){
            tm.put(arr[i], tm.getOrDefault(arr[i], 0) + 1);
        }
        
        int size = tm.size();
        int temp[] = new int[n+1];
        
        for(Integer key: tm.keySet()) temp[tm.get(key)]++ ;

        //Arrays.sort(temp);

        for(int i=1; i<n+1; i++){
            int canRemove = k/i;
            int possRemoval = Math.min(canRemove, temp[i]);

            size -= possRemoval;

            k -= i*possRemoval;
            

            if(k<=0) 
             break;
        }
        return size;
    }
}