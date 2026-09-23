class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;

        int i=0;
        int j= n/2 - 1;

        long tot_sum=0;

        long sum_first=0;

        for(int k=0; k<n; k++){
            tot_sum += nums[k];

            if(k <= j) sum_first += nums[k];
        }

        long sum_second = tot_sum - sum_first;

        //System.out.println(sum_first+" "+sum_second);

        int count=0;

        if(sum_first > sum_second) count++;

    
        while(i<n){
            

            sum_first -= nums[i];
            

            i++;

            if(i>=n) break;
            j++;
            if(j>=n) j = j%n;
            sum_first += nums[j];

            sum_second = tot_sum - sum_first;
            //System.out.println(sum_first+" "+sum_second);


            if(sum_first > sum_second) count++;

            
        }

        return count;
        

    
        
    }
}