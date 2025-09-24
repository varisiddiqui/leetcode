class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> li = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]%2 !=0){
                li.add(i);
            }
        }


        int left=0;
        int right=0;

        int sz = li.size();
        if(sz < k) return 0;
        int ans=0;
        
        for(int i=0; i<sz; i++){
            left = (i-1 >= 0)? (li.get(i)-li.get(i-1)): (li.get(i)+1);
            if(i+k-1 >= sz) break;
            right = ((i+k) < sz)? (li.get(i+k) - li.get(i+k-1)): (n - li.get(i+k-1));
            ans += (left*right);


        }

        return ans;
    }
}