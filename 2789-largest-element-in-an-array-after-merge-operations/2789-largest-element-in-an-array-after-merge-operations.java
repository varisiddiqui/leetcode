class Solution {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        Stack<Long> s = new Stack<>();
        long max = Long.MIN_VALUE;

        for(int i=n-1; i>=0; i--){
            //case-1
            if(s.isEmpty()) s.push((long)nums[i]);

            //case-2
            else if(s.peek() >= nums[i]){
                long curr = s.pop()+nums[i];
                
                while(!s.isEmpty() && s.peek() >= curr){
                    curr = s.pop()+curr;
                }
                s.push(curr);
            }

            //case-3
            else s.push((long)nums[i]);
        }

        while(!s.isEmpty()) max = Math.max(s.pop(), max);
        return max;
    }
}