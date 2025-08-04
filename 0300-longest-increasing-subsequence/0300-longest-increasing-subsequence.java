class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;

        ArrayList<Integer> li = new ArrayList<>();
        li.add(nums[0]);

        for(int i=1; i<n; i++){
            if(nums[i] > li.get(li.size()-1)){
                li.add(nums[i]);
            }
            else{
                int l=0, r=li.size()-1, ans=li.size();

                while(l<=r){
                    int mid = l+(r-l)/2;
                    if(li.get(mid) >= nums[i]){
                        ans=mid;
                        r=mid-1;
                    }
                    else{
                        l=mid+1;
                    }
                }
                li.set(ans, nums[i]);
            }
        }
  
        return li.size();
        
    }

   
    
}