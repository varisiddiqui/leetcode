class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        int n = nums.length;
        List<Long> ans = new ArrayList<>();
        

        if(n==1) return new ArrayList<>(Arrays.asList((long)nums[0]));

        Stack<Long> s = new Stack<>();
        s.push((long)nums[0]);

        for(int i=1; i<n; i++){
            
                if(s.peek() == nums[i]){                  
                    long curr = s.pop()+(long)nums[i];
                    while(!s.isEmpty() && curr == s.peek()){
                        curr = 2*s.pop();                        
                    }
                    s.push(curr);
                }
                else{
                    s.push((long)nums[i]);
                }
            
        }

        while(!s.isEmpty()){
            ans.add(0, s.pop());
        }
        return ans;
    }
}