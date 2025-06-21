class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n=0;
        ArrayList<Integer> ans = new ArrayList<>();

        if(nums1.length<=nums2.length){
            n=nums1.length;
            boolean vis[] = new boolean[n];
            for(int i=0; i<nums2.length; i++){
                for(int j=0; j<nums1.length; j++){
                    if(nums2[i]==nums1[j] && !vis[j]){
                        vis[j]=true;
                        ans.add(nums2[i]);
                        break;
                    }
                }
        }
        }

        else{
            n=nums2.length;
            boolean vis[]=new boolean[n];
            for(int j=0; j<nums1.length; j++){
                for(int i=0; i<nums2.length; i++){
                    if(nums1[j]==nums2[i] && !vis[i]){
                        vis[i]=true;
                        ans.add(nums1[j]);
                        break;
                    }
                }
            }
        }
        int arr[]=new int[ans.size()];
        for(int i=0; i<arr.length; i++)
        arr[i]=ans.get(i);
        return arr;

        
        
    }
}