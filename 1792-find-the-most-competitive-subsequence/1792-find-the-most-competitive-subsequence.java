class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int stack[] = new int[k];
        int top=0;

        for(int i=0; i<n; i++){
            int remaining = n-i-1;

            while(top>0 && stack[top-1] > nums[i] && top-1+remaining+1 >= k){
                top--;
            }

            if (top<k){
                stack[top++] = nums[i];
            }
        }

        return stack;
    }
}