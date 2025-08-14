class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
       int  rem = nums.length-k;

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length; i++){
            if(st.isEmpty()){
                st.push(nums[i]);
            }

            else if(st.peek() > nums[i] && rem>0){
                while(!st.isEmpty() && st.peek()>nums[i] && rem>0){
                    st.pop();
                    rem--;
                }
                st.push(nums[i]);
            }
            else{
                st.push(nums[i]);
            }
        }

        while(rem-->0){
            st.pop();
        }

        int a[] = new int[k];
        int i=k-1;
        while(!st.isEmpty()){
            a[i--] = st.pop();
        }
        return a;

    }
}