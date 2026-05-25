class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length;
        int eq = n/3;
        long leftMinSum[] = new long[n];
        long rightMaxSum[] = new long[n];

        leftMinSum[0] = nums[0];
        rightMaxSum[n-1] = nums[n-1];
        

        PriorityQueue<Integer> leftMins = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightMaxs = new PriorityQueue<>();

        leftMins.add(nums[0]);
        rightMaxs.add(nums[n-1]);

        //putting 1st n/3 element in sum and pq
        for(int i=1; i<eq; i++){ 
            leftMins.add(nums[i]);
            leftMinSum[i] = leftMinSum[i-1]+nums[i];
        }

        //calculating leftMin for entire
        for(int i=eq; i<(2*n)/3; i++){
            if(leftMins.peek() > nums[i]){
                leftMinSum[i] = leftMinSum[i-1]-leftMins.poll()+nums[i];
                leftMins.add(nums[i]);
            }
            else if(i-1>=0) leftMinSum[i] = leftMinSum[i-1];
        } 


        //putting last n/3 element in sum and pq

        for(int i=n-2; i>=(2*n)/3; i--){
            rightMaxs.add(nums[i]);
            rightMaxSum[i] = rightMaxSum[i+1]+nums[i];
        }

        //putting rightMax for entire
        for(int i=((2*n)/3)-1; i>=eq; i--){
            if(rightMaxs.peek()<nums[i]){
                rightMaxSum[i] = rightMaxSum[i+1]-rightMaxs.poll()+nums[i];
                rightMaxs.add(nums[i]);
            }
            else if(i+1<n) rightMaxSum[i] = rightMaxSum[i+1];
        }

        long ans = Long.MAX_VALUE;

        
        for(int i=eq-1; i<(2*n)/3; i++){
            ans = Math.min(ans, leftMinSum[i]-rightMaxSum[i+1]);
        }

        return ans;

        



        
    }
}