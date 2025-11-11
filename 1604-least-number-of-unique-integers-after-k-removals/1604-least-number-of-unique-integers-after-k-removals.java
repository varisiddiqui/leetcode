class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> tm = new HashMap<>();
        for(int i=0; i<n; i++){
            tm.put(arr[i], tm.getOrDefault(arr[i], 0) + 1);
        }
        
        int size = tm.size();
        int temp[] = new int[size];
        int i=0;
        for(Integer key: tm.keySet()) temp[i++] = tm.get(key);

        Arrays.sort(temp);

        for(int freq: temp){
            
            k -= freq;
            if(k>=0) size--;

            if(k<0) 
             break;
        }
        return size;
    }
}