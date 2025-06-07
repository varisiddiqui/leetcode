class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();

        int j=n-1;
        while(j>=0){
            //find max
            int max=0;
            int pos=-1;
            for(int l=0; l<=j; l++){
                if(max<arr[l]){
                    max = arr[l];
                    pos = l;
                }
            }

            //flip max to first
            if(pos+1 != max){

            int m=0;
            for(int l=pos; l>pos/2; l--){
                int temp = arr[m];
                arr[m] = arr[l];
                arr[l] = temp;
                m++;                
            }
            ans.add(pos+1);

            m=0;
            for(int l=max-1; l>(max-1)/2; l--){
                int temp = arr[m];
                arr[m] = arr[l];
                arr[l] = temp;
                m++;  
            }
            ans.add(max);

            }

            j--;

        }
        return ans;
    }
}