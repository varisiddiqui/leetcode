class Solution {
    public int smallestAbsent(int[] nums) {
        int n = nums.length;
        int avg = 0;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            avg += nums[i];
            set.add(nums[i]);
        }

        avg = avg/n;
        if(avg < 0)
        avg = 1;
        else
        avg++;

        while(set.contains(avg)){
            avg++;
        }
        return avg;

        
        
       
    }
}