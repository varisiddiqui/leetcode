class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int c[] = new int[n];
        Set<Integer> set = new HashSet<>();
        
    

        for(int i=0; i<n; i++){
            set.add(A[i]);
            int cnt=0;
           for(int j=0; j<=i; j++){
            if(set.contains(B[j])) cnt++;
           }
           c[i]=cnt;
        }
        return c;
    }
}