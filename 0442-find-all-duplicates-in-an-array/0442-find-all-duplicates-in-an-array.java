class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int count[] = new int[n];
        for(int i=0; i<n; i++){
            count[nums[i]-1]++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(count[i]==2)
            ans.add(i+1);
        }

        //System.out.println(ans);
        return ans;
    }
}