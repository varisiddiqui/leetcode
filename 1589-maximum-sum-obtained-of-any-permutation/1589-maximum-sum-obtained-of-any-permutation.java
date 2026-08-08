class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int freq[] = new int[n];

        for(int i=0; i<requests.length; i++){
            int st = requests[i][0];
            int end = requests[i][1];

            freq[st]++;
            if(end+1 < n) freq[end+1]--;

        }

        int prefix[] = new int[n];
        int count=0;

        for(int i=0; i<n; i++){
            count += freq[i];
            prefix[i] = count;
        }


        Arrays.sort(nums);

        Arrays.sort(prefix);

       

        long sum=0;
        
        for(int i=n-1; i>=0; i--){
            if(prefix[i] == 0) break;

            sum += (1L* prefix[i]*nums[i]);
        }

        return (int)(sum % 1_000_000_007);
    }
}