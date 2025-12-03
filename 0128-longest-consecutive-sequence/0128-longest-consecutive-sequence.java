class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Boolean> visited = new HashMap<>();

        for(int num: nums)
        visited.put(num, false);

        int max=0;

        for(int i=0; i<n; i++){
            if(visited.get(nums[i])) continue;
            int count=0;
            int right=nums[i]+1;
            while(!visited.getOrDefault(right, true)){
                count++;
               
                visited.put(right, true);
                 right++;
            }
            int left=nums[i];
            while(!visited.getOrDefault(left, true)){
                count++;
                
                visited.put(left, true);
                left--;
            }

            max = Math.max(count, max);
        }
        return max;
    }
}