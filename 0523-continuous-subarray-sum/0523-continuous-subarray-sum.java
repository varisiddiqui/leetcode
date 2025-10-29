class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n==1) return false;
        HashMap<Integer,Integer> set = new HashMap<>();
        set.put(0,-1);
        int sum=0;
        for(int i=0; i<n; i++){
            if(i+1<n && nums[i]==0 && nums[i+1]==0) return true;
            sum += nums[i];
            int d = sum%k;
            if(set.containsKey(d) && i>0 && set.get(d)!= (i-1) && sum>=k)
            return true;
        
            set.putIfAbsent(d, i);
        }
        //System.out.println(set);
        return false;
    }
}
