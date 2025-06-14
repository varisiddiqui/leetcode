class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for(int i=0; i<nums1.length; i++){
            s1.add(nums1[i]);
        }
        for(int i=0; i<nums2.length; i++){
            s2.add(nums2[i]);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(Integer key: s1){
            if(s2.contains(key))
            ans.add(key);
        }
        int a[] = new int[ans.size()];
        for(int i=0; i<a.length; i++){
            a[i]=ans.get(i);
        }
        return a;
    }
}