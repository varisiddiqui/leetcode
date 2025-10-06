class Solution {
    public int minOperations(int k) {
        int rem = k-1;
        int curr=1;
        int op=0;

        while(rem>0){
            if(rem-curr<=0) return ++op;
            int choice1 = (int)Math.ceil((rem-1)/(double)(curr+1));
            int choice2 = (int)Math.ceil((rem-curr)/(double)curr);
            if(choice1 > choice2){
                op++;
                rem -= curr;
            }
            else if(choice1 < choice2){
                op++;
                rem -= 1;
                curr++;
            }
            else{
                op++;
                rem -= 1;
                curr++;
            }
        }
        return op;
    }
}