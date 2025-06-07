class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int arr[][] = new int[n][2];
        //initialise
        for(int i=0; i<n; i++){
            arr[i][0] = values[i];
            arr[i][1] = labels[i];
        }
        //sort on values
        Arrays.sort(arr, (a,b) -> Integer.compare(b[0], a[0]));

        //create hashmap
        HashMap<Integer, Integer> hm = new HashMap<>();

        int sum=0;
        for(int i=0; i<n; i++){
            if(numWanted == 0) break;
            if(!hm.containsKey(arr[i][1])){
                sum += arr[i][0];
                hm.put(arr[i][1], 1);
                numWanted--;
            }
            else if(hm.get(arr[i][1]) < useLimit){
                sum += arr[i][0];
                hm.put(arr[i][1], hm.get(arr[i][1])+1);
                numWanted--;
            }
        }
       // System.out.println(hm);
        return sum;


    }
}