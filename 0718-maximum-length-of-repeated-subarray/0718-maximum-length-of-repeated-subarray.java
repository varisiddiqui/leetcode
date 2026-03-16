class Solution {

    public int maxL(int nums1[], int nums2[], int i, int j){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int len=0;
        while(i<n1 && j<n2){
            if(nums1[i++] == nums2[j++]) len++;
            else break;
        }
        return len;
    }

    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int maxLength = Integer.MIN_VALUE;

        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                if(nums1[i] == nums2[j]){
                    maxLength = Math.max(maxLength, maxL(nums1, nums2, i, j));
                }
            }
        }
        return (maxLength == Integer.MIN_VALUE)? 0: maxLength;
    }
}