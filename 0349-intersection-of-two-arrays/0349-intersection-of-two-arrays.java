class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for(int i=0; i<nums1.length; i++){
            s1.add(nums1[i]);
        }
        for(int i=0; i<nums2.length; i++){
            if(s1.contains(nums2[i]))
            s2.add(nums2[i]);
        }

        int a[] = new int[s2.size()];
        int l=0;
        for(Integer key: s2){
            a[l++]=key;
        }
        return a;
    }
}