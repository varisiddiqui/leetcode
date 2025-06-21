class Solution {
    public int minOperations(int[] nums) {
        int min = Integer.MAX_VALUE;
        //find min
        for(int i=0; i<nums.length; i++){
            min = Math.min(min, nums[i]);
        }

        //min=0;
        int count=0;
        
    
        
        
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<nums.length; i++){
            if(s.isEmpty()){
                s.push(nums[i]);
            }
            else if(s.peek()==nums[i]) continue;
            else if(s.peek()<nums[i]) s.push(nums[i]);
            else if(s.peek()>nums[i]){
                while(!s.isEmpty() && s.peek()>nums[i]){
                    s.pop();
                    count++;
                }

                 if(s.isEmpty())   
                s.push(nums[i]);
                else if(s.peek()!=nums[i])
                s.push(nums[i]);
            }
        }
        count = count+s.size();
        if(min==0) count--;
        return count;

        
        
    }
}