class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        int ans=0;
        List<Integer> li = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(nums[i]%2 != 0)
            li.add(i);
        }

        //System.out.println(li);

        int sz = li.size();
        if(sz<k) return 0;

        int prev=-1;
        int next=-1;

        for(int i=0; i<sz; i++){
            if(i-1>=0){
                prev = li.get(i) - li.get(i-1);
            }
            else{
                prev = li.get(i) + 1;
            }

            next = i+k-1;

            if(next >= sz) break;

            if(next+1 < sz){
                next = li.get(next+1) - li.get(next);
            }
            else{
                next = n-li.get(next);
            }

            ans += (prev*next);
        }

        return ans;



       
    }
}