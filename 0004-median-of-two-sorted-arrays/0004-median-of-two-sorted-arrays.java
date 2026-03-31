class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> li = new ArrayList<>();

        int i=0;
        int j=0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        while(i<n1 && j<n2){
            if(nums1[i] < nums2[j]){
                li.add(nums1[i++]);
            }
            else li.add(nums2[j++]);
        }

        while(i<n1) li.add(nums1[i++]);
        while(j<n2) li.add(nums2[j++]);

        int n = li.size();

        return (n%2==0)?((li.get(n/2-1)+li.get(n/2)))/2.0: li.get((n+1)/2 -1);
    }
}