class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         if(n == 0){
            nums1 = nums1;
        }
        else if(m == 0){
            for(int i=0; i<m+n; i++)
            nums1[i]=nums2[i];
        }
        else{
            int j=0;
            for(int i=m ;i<(m+n); i++){
                nums1[i] = nums2[j++];
                int curr = nums1[i];
                int prev = i-1;
                
                while(prev >=0 && curr < nums1[prev]){
                    nums1[prev+1] = nums1[prev];
                    prev--;
                }
                nums1[prev+1] = curr;
            }
        }
    }
}