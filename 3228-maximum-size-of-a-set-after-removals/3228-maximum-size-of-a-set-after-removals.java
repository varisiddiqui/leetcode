class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> common = new HashSet<>();

        for(int i=0; i<n; i++){
            s1.add(nums1[i]);
        }
        for(int i=0; i<n; i++){
            if(s1.contains(nums2[i])){
                common.add(nums2[i]);
            }
            
            s2.add(nums2[i]);
        }
        
        int unique1 =  Math.min(n/2, s1.size()-common.size());
        int unique2 =  Math.min(n/2, s2.size()-common.size());
        int remC=common.size();

        if(remC > 0 && unique1 < n/2){
            int mini = Math.min(remC , (n/2-unique1));
            unique1 += mini;
            remC -= mini;

        }

        if(remC > 0  && unique2 < n/2){
            int mini = Math.min(remC, (n/2-unique2));
            unique2 += mini;
        }

        return Math.min(unique1+unique2, n);
        
        


    }
}