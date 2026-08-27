class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
       
        List<Integer> li = new ArrayList<>();
        li.add(nums[0]);

        for(int i=1; i<n; i++){
            int idx = lowerBound(li, nums[i]);
            if(idx == li.size()) li.add(nums[i]);
            else 
            li.set(idx, nums[i]);
        }
        System.out.println(li);
        return li.size();
    }

    public int lowerBound(List<Integer> li, int key){
        int low=0;
        int high = li.size()-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(key <= li.get(mid)){

                high = mid-1;
            }

            else low = mid+1;
        }

        return low;
    }
}