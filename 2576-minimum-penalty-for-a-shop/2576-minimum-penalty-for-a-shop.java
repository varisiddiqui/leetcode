class Solution {
    public int bestClosingTime(String customers) {
        int tot_N = 0;
        int tot_Y = 0;
        int n = customers.length();

        for(int i=0; i<n; i++){
            if(customers.charAt(i) == 'N') tot_N++;
            else tot_Y++;
        }

        int back_N=0;
        int back_Y=0;

        int min=tot_N; //when j=n
        int hour=n; //last hour

        for(int i=n-1; i>=0; i--){
            if(customers.charAt(i) == 'N') back_N++;
            else back_Y++;

            int curr_penalty = (tot_N - back_N) + (back_Y);

            if(min>= curr_penalty){
                min = curr_penalty;
                hour = i;
            }
            
        }
        return hour;




    }
}